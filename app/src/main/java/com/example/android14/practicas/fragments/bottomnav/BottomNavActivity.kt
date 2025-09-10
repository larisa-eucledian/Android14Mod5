package com.example.android14.practicas.fragments.bottomnav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.android14.R
import com.example.android14.databinding.ActivityBottomNavBinding
import com.example.android14.practicas.fragments.navigation.FragmentA
import com.example.android14.practicas.fragments.navigation.FragmentB
import com.example.android14.practicas.fragments.navigation.FragmentC

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    loadFragment(FragmentA.newInstance())

        binding.navigationNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.page_opt1 ->{
                    loadFragment(FragmentA.newInstance())
                    return@setOnItemSelectedListener true
                }

                R.id.page_home ->{
                    loadFragment(FragmentB.newInstance("Larisa"))
                    return@setOnItemSelectedListener true
                }

                R.id.page_config->{
                    loadFragment(FragmentC.newInstance())
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}

