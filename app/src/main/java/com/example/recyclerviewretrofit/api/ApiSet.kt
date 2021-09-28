package com.example.recyclerviewretrofit.api

import com.example.recyclerviewretrofit.models.Names
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BaseUrl="https://jsonkeeper.com"
interface ApiSet {
    @GET("/b/XAJK")
    suspend fun getNames(): Response<Names>
}


object NameService{
    val apiSet: ApiSet
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiSet =retrofit.create(ApiSet::class.java)
    }
}