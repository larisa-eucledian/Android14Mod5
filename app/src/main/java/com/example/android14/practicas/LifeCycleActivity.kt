package com.example.android14.practicas

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.e("LifeCycleActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("LifeCycleActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LifeCycleActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCycleActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifeCycleActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCycleActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LifeCycleActivity", "onRestart")
    }
}