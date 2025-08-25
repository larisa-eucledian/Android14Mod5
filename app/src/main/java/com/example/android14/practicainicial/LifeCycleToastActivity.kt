package com.example.android14.practicainicial

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class LifeCycleToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle_toast)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Toast.makeText(this, " LifeCycleToastActivity: onCreate", Toast.LENGTH_SHORT).show()

    val btnSendUrl = findViewById<Button>(R.id.btnSendUrl)
    val btnOpenFirstActivity = findViewById<Button>(R.id.btnOpenFirstActivity)

        btnSendUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            startActivity(Intent.createChooser(urlIntent, "Open using:"))
        }

        btnOpenFirstActivity.setOnClickListener {
            val firstActivityIntent = Intent(this, FirstPracticeActivity::class.java)
            startActivity(firstActivityIntent)
        }

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "LifeCycleToastActivity: onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "LifeCycleToastActivity: onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "LifeCycleToastActivity: onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "LifeCycleToastActivity: onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "LifeCycleToastActivity: onDestroy", Toast.LENGTH_SHORT).show()
    }
}