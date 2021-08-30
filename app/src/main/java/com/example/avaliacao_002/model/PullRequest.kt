package com.example.avaliacao_002.model

import com.google.gson.annotations.SerializedName


data class PullRequest(
    val title: String,

    val user: User,

    val body: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("html_url")
    val link: String
) {
    fun formattedDate(): String {
        val dateWithoutHours = createdAt.split("T")[0].split("-")

        return "${dateWithoutHours[2]}/${dateWithoutHours[1]}/${dateWithoutHours[0]}"
    }
}

data class User(
    @SerializedName("login")
    val username: String,

    @SerializedName("avatar_url")
    val avatarURL: String
)
