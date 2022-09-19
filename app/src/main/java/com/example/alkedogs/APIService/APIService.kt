package com.example.alkedogs.APIService

import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    fun getListOfDogsByBreed(@Url breed : String){

    }
}