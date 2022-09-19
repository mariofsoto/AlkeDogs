package com.example.alkedogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.alkedogs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svDogBreed.setOnQueryTextListener(this)
        //Iniciar el Recycler

        initRecyclerView()
        //Capturar la busqueda
    }

    private fun findDogsByBreed(query: String) {
        //Tomar query y llamar a la API
        //Crear instancia de Retro
        //Carga de datos al recycler



    }

    private fun initRecyclerView() {
        //crear adapter
        //init

        //bindear
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        query?.let {
            if (query.isNotBlank()) {
                findDogsByBreed(query)
            }
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}