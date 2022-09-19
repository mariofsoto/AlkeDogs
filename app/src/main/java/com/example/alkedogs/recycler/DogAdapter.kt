package com.example.alkedogs.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkedogs.R

class DogAdapter(private val dogImages: List<String>) : RecyclerView.Adapter<DogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.dog_view_holder, parent, false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogAtPosition = dogImages[position]
        holder.onBind(dogAtPosition)
    }

    override fun getItemCount(): Int = dogImages.size
}