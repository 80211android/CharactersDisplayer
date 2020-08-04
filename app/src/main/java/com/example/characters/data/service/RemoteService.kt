package com.example.characters.data.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RemoteService {

    val gson = GsonBuilder()
        .setLenient()
        .create()

    val getClient: ApiEndpoints
    get() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(ApiEndpoints::class.java)
    }
    const val baseUrl = "https://rickandmortyapi.com/api/"
}