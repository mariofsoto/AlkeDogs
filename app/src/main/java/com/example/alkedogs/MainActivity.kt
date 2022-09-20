package com.example.alkedogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkedogs.Service.APIService
import com.example.alkedogs.Service.DogResponse
import com.example.alkedogs.databinding.ActivityMainBinding
import com.example.alkedogs.recycler.DogAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter

    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svDogBreed.setOnQueryTextListener(this)

        initRecyclerView()
    }

    private fun initRecyclerView() {

        adapter = DogAdapter(dogImages)
        binding.rvDogImages.layoutManager = LinearLayoutManager(this)
        binding.rvDogImages.adapter = adapter
    }

    private fun findDogsByBreed(query: String) {

        CoroutineScope(Dispatchers.IO).launch {

            val APIresponse: Response<DogResponse> = getRetrofit()
                .create(APIService::class.java)
                .getListOfDogsByBreed("$query/images")

            val dogResponse: DogResponse? = APIresponse.body()

            runOnUiThread {
                if (APIresponse.isSuccessful) {
                    val dogImagesAPI = dogResponse?.dogImages ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(dogImagesAPI)
                    adapter.notifyDataSetChanged()
                }
            }
        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
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