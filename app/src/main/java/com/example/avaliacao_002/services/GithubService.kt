package com.example.avaliacao_002.services

import com.example.avaliacao_002.model.PullRequest
import com.example.avaliacao_002.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/search/repositories?")
    fun getRepositoriesList(
        @Query("q") language: String,
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int = 1
    ): Call<RepositoryResponse>

    @GET("/repos/{fullName}/pulls")
    fun getPullRequestsList(
        @Path(
            "fullName",
            encoded = true
        ) fullName: String
    ): Call<List<PullRequest>>

}