package com.example.avaliacao_002.services

import com.example.avaliacao_002.model.PullRequest
import com.example.avaliacao_002.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositoriesList(): Call<RepositoryResponse>

    @GET("https://api.github.com/repos/{fullName}/pulls")
    fun getPullRequestsList(@Path("fullName") fullName: String): Call<List<PullRequest>>

}