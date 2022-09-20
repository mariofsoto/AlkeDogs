package com.example.alkedogs.Service

import com.google.gson.annotations.SerializedName

data class DogResponse(@SerializedName("message") var dogImages : List<String>,
                       var status : String)


