package com.example.integrador_android

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ActivityViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    fun bind(activitiesEnPosicion: ActivityClass) {

    }

}





    private val binding = FilaPerroBinding.bind(view)
    // toma imagen y la carga en el imageView
    fun bind(imagen : String){

        Picasso.get().load(imagen).into(binding.ivPerro)

    }
