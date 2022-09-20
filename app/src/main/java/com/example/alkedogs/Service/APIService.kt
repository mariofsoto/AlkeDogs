package com.example.alkedogs.Service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getListOfDogsByBreed(@Url breed : String) : Response<DogResponse>
}