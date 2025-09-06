package com.example.android14.practicas.graphiccomponents.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android14.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Lista de Animales"

        val list = findViewById<RecyclerView>(R.id.list)

//COLECCIÓN DE DATOS
        val data = listOf(
        AnimalEntity("Leon","Amarillo",""),
        AnimalEntity("Pulpo","Morado",""),
        AnimalEntity("Tigre","Naranja",""),
        AnimalEntity("Iguana","Verde",""),
        AnimalEntity("Xolo","Gris",""),
        AnimalEntity("Oso","Negro",""), AnimalEntity("Leon","Amarillo",""),
        AnimalEntity("Pulpo","Morado",""),
        AnimalEntity("Tigre","Naranja",""),
        AnimalEntity("Iguana","Verde",""),
        AnimalEntity("Xolo","Gris",""),
        AnimalEntity("Oso","Negro",""))


        val adapter = AnimalAdapter(data)
        adapter.onRowSelected ={
            val intent = Intent(this, SecondRecyclerActivity::class.java)
            intent.putExtra("extra_animal", it)
            startActivity(intent)

            //TODO Crear Intent y Mandar a llamar segunda activity y pasar la información de animalEntity (it)
            Toast.makeText(this,"Item selected: ${it.name}", Toast.LENGTH_SHORT).show()
        }

        list.adapter = adapter
            list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //GRID     list.layoutManager = GridLayoutManager(this,2)
        //SLIDER   list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}