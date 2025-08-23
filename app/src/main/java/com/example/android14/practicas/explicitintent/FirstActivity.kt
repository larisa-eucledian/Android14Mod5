package com.example.android14.practicas.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class FirstActivity : AppCompatActivity() {
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
                putExtra("EXTRA_PRICE_KEY",99.99)
                putExtra("EXTRA_BUNDLE_KEY",extraBundle)
            }
            startActivity(secondIntent)
        }
        }
}