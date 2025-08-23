package com.example.android14.practicas.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class FirstActivity : AppCompatActivity() {

    //TOAST Implementation Receive Result
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val booleanResult = result.data?.getBooleanExtra("EXTRA_BOOLEAN_KEY", false)
            val person1 = result.data?.getSerializableExtra("EXTRA_PERSON_KEY") as Person
            Toast.makeText(this, "Result OK $booleanResult , ${person1.name}", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(this, "Result CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnOpen = findViewById<Button>(R.id.btnOpen)

        btnOpen.setOnClickListener {
            val extraBundle = Bundle().apply {
                putBoolean("EXTRA_IS_MARRIED_KEY", true)
                putString("EXTRA_SURNAME_KEY","Clemenceau")
            }

            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY","Larisa")
                putExtra("EXTRA_AGE_KEY",34)
                putExtra("EXTRA_PRICE_KEY",59.32)
                putExtra("EXTRA_BUNDLE_KEY",extraBundle)
            }
//            startActivity(secondIntent)

            register.launch(secondIntent)
        }
        }
}