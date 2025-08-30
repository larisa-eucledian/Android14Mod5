package com.example.android14.practicas.graphiccomponents

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R
import com.google.android.material.navigation.NavigationBarView

class BasicComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basic_components)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etExample = findViewById<EditText>(R.id.etExample)
        val cbExample = findViewById<CheckBox>(R.id.cbExample)
        val btnExample = findViewById<Button>(R.id.btnExample)
        val rgExample = findViewById<RadioGroup>(R.id.rgExample)
        val spinner = findViewById<Spinner>(R.id.spExample)
        val etEmail =findViewById<EditText>(R.id.etExampleEmail)

        //CHECKBOX
        cbExample.isChecked = true
        cbExample.setOnCheckedChangeListener { compoundButton, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_LONG).show()
        }


        //RADIO
        rgExample.setOnCheckedChangeListener { rgExample, id ->
            val idName = getRGExampleLabel(id)
            Toast.makeText(this, "radioButtonSelected = $idName", Toast.LENGTH_LONG).show()
        }

        //SPINNER
        val data = arrayListOf("No selection","México","Panama","USA","Canada","Italia","Japón","China","Corea","Rusia","México","Panama","USA","Canada","Italia","Japón","China","Corea","Rusia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = data[position]
                if (position == 0) {
                    Toast.makeText(
                        this@BasicComponentsActivity,
                        "Item not selected",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@BasicComponentsActivity,
                        "Item selected = $itemSelected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@BasicComponentsActivity, "Nothing Selected", Toast.LENGTH_SHORT).show()
            }
        }

        btnExample.setOnClickListener {
            if (etExample.text.toString().isEmpty() || spinner.selectedItem == "No selection" || etEmail.text.toString().isEmpty()) {
                Toast.makeText(this, "¡Llena todos los campos!", Toast.LENGTH_SHORT).show()
            } else {
                val cbExampleStatus = cbExample.isChecked
                val selectedRGOption = getRGExampleLabel(rgExample.checkedRadioButtonId)
                val selectedItem = spinner.selectedItem

                Toast.makeText(
                    this,
                    "isChecked = $cbExampleStatus, radioButtonSelected = $selectedRGOption, selectedItem = $selectedItem",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun getRGExampleLabel(id : Int) : String{
        return when(id){
            R.id.rbA ->{
                "Opción A"
            }
            R.id.rbB ->{
                "Opción B"
            }
            else -> "Unknown"
        }
    }
}