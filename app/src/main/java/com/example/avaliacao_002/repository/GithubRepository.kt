package com.example.avaliacao_002.repository

import com.example.avaliacao_002.model.RepositoryResponse
import com.example.avaliacao_002.model.Repository
import com.example.avaliacao_002.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepository {

    private val service = RetrofitBuilder.getGithubServices()

    fun getRepositoriesList(callback: (List<Repository>?, String?) -> Unit) {
        val call = service.getRepositoriesList()

        call.enqueue(object : Callback<RepositoryResponse> {
            override fun onResponse(call: Call<RepositoryResponse>, response: Response<RepositoryResponse>) {
                if (response.body() != null) {
                    callback(response.body()!!.items, null)
                } else {
                    callback(null, "Ocorreu um erro")
                }
            }

            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {
                callback(null, t.localizedMessage)
            }

        })
    }

}