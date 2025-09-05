package com.example.android14.practicas.compose

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class ComposeWelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compose_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val composeView = findViewById<ComposeView>(R.id.composeView)
        composeView.setContent {
            WelcomeScreen()
        }
    }
    @Composable
    fun WelcomeScreen(){
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
            Text("Hola desde Compose dentro de XML")
            Spacer(modifier = Modifier.height(50.dp))
            Text("Hola desde Compose dentro de XML 2")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {}) {
                Text("Next")
            }
        }
    }

    @Preview
    @Composable
    fun WelcomePreview(){
        WelcomeScreen()
    }
}