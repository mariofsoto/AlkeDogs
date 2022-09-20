package com.example.alkedogs.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.alkedogs.databinding.DogViewHolderBinding
import com.squareup.picasso.Picasso

class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DogViewHolderBinding.bind(view)

    fun onBind(dogAtPosition: String) {

        Picasso.get().load(dogAtPosition).into(binding.ivDog)
    }

}
