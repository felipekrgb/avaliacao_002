package com.example.avaliacao_002.services

import com.example.avaliacao_002.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositoriesList(): Call<RepositoryResponse>

}