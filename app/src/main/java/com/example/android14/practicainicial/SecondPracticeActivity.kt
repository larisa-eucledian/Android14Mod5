package com.example.android14.practicainicial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class SecondPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_practice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtLastName = findViewById<TextView>(R.id.txtLastName)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val btnReturnResult = findViewById<Button>(R.id.btnReturnResult)

        val inBundle = intent.getBundleExtra("EXTRA_BUNDLE")
        val person = inBundle?.getSerializable("EXTRA_PERSON", Person::class.java)

        person?.let{
            txtName.text = "Nombre: ${it.name}"
            txtLastName.text = "Apellido: ${it.lastName}"
            txtEmail.text = "Email: ${it.email}"
        }

        btnReturnResult.setOnClickListener {
            val outBundle = Bundle().apply {
                putSerializable("EXTRA_PERSON_RESULT", person)
            }

            val outIntent = Intent().apply {
                putExtra("EXTRA_BUNDLE", outBundle)
            }

            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }

}