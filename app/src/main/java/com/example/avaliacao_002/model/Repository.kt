package com.example.avaliacao_002.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositoryResponse(
    val items: List<Repository>
)

data class Repository(
    @SerializedName("full_name")
    val fullName: String,

    val owner: Owner,

    val description: String,

    @SerializedName("stargazers_count")
    val starsCount: Int,

    @SerializedName("forks_count")
    val forksCount: Int,
) : Serializable

data class Owner(
    @SerializedName("avatar_url")
    val avatarURL: String
)