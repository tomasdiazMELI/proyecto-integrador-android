package com.example.integrador_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter (private val activities : List<ActivityClass>) : RecyclerView.Adapter<ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
       /* val layoutInflater = LayoutInflater.from(parent.context)
        return ActivityViewHolder(layoutInflater.inflate(R.layout.fila_perro, parent, false))*/
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activitiEnPosicion = activities[position] /// ej: https://images.dog.ceo//breeds//hound-afghan//n02088094_10263.jpg
        //llamar al holder y le paso la imagen a cargar
        holder.bind(activitiesEnPosicion)
    }

    override fun getItemCount() = activities.size
}




override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {

}

override fun getItemCount(): Int = imagenes.size