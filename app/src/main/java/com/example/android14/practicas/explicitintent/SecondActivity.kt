package com.example.android14.practicas.explicitintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        var infoReceived = ""

        intent.extras?.let { info ->
            if (info.containsKey("EXTRA_NAME_KEY")){
                infoReceived += info.getString("EXTRA_NAME_KEY","")
            }
            if (info.containsKey("EXTRA_AGE_KEY")){
                infoReceived += info.getInt("EXTRA_AGE_KEY",0)
            }
            if (info.containsKey("EXTRA_BUNDLE_KEY")){
                val bundle =info.getBundle("EXTRA_BUNDLE_KEY")

                bundle?.let {
                    infoReceived += ", " +bundle.getString("EXTRA_SURNAME_KEY","")
                    infoReceived += ", " +bundle.getBoolean("EXTRA_IS_MARRIED_KEY,")
                }
            }
        }

        //Second
        val name = intent.getStringExtra("EXTRA_NAME_KEY")
        val age = intent.getIntExtra("EXTRA_AGE_KEY",0)

        name?.let{
            infoReceived += ", $it"
        }

        age.let {
            infoReceived += it
        }

        tvInfo.text = infoReceived

    }
}