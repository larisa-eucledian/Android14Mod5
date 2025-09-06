package com.example.android14.practicas.graphiccomponents.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android14.R
import com.squareup.picasso.Picasso

class AnimalAdapter(val list: List<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var onRowSelected : ((AnimalEntity) -> Unit)? = null


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal,parent,false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AnimalViewHolder,
        position: Int
    ) {
        holder.render(list[position], onRowSelected)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
       val ivAnimal = view.findViewById<ImageView>(R.id.ivItem)
       val cardAnimal = view.findViewById<CardView>(R.id.cardItem)
       val tvItemTitle = view.findViewById<TextView>(R.id.tvItemTitle)
       val tvItemDescription = view.findViewById<TextView>(R.id.tvItemDescription)

       fun render(animalEntity: AnimalEntity, onRowSelected : ((AnimalEntity) -> Unit)?){
           tvItemTitle.text = animalEntity.name
           tvItemDescription.text = animalEntity.color

          if (animalEntity.image.isNotEmpty()){
              Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
                  .placeholder(R.drawable.img_placeholder)
                  .error(R.drawable.ic_delete)
                  .into(ivAnimal)
          }

           cardAnimal.setOnClickListener {
               onRowSelected?.invoke(animalEntity)
           }
       }
    }
}