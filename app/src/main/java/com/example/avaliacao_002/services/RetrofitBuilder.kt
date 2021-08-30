package com.example.avaliacao_002.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(
        GsonConverterFactory.create()).build()

    fun getGithubServices() : GithubService {
        return retrofit.create(GithubService::class.java)
    }

}