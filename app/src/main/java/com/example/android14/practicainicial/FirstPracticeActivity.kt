package com.example.android14.practicainicial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class FirstPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_practice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.editTextName)
        val lastName = findViewById<EditText>(R.id.editTextLastName)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val btnOpenSecondActivity = findViewById<Button>(R.id.btnOpenSecondActivity)
        val txtResult = findViewById<TextView>(R.id.txtResult)


        val register = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {result->
            if (result.resultCode == Activity.RESULT_OK){
                val bundle = result.data?.getBundleExtra("EXTRA_BUNDLE")
                val personResult = bundle?.getSerializable("EXTRA_PERSON_RESULT", Person::class.java)

                personResult?.let{
                    txtResult.text = "Confimed:\n${it.name} ${it.lastName} ${it.email}"
                }

            }
        }


        btnOpenSecondActivity.setOnClickListener {
            val person = Person(
                name.text.toString(),
                lastName.text.toString(),
                email.text.toString()
            )

            val bundle = Bundle().apply {
                putSerializable("EXTRA_PERSON", person)
            }

            val intent = Intent(this, SecondPracticeActivity::class.java).apply {
                putExtra("EXTRA_BUNDLE", bundle)
            }

            register.launch(intent)
        }

    }
}