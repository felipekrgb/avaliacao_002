package com.example.avaliacao_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avaliacao_002.model.PullRequest
import com.example.avaliacao_002.repository.GithubRepository

class PullRequestsViewModel : ViewModel() {

    private val _pullRequests = MutableLiveData<List<PullRequest>>()
    val pullRequests: LiveData<List<PullRequest>> = _pullRequests

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val githubRepository = GithubRepository()

    fun getPullRequestsList(fullName: String) {
        githubRepository.getPullRequestsList(fullName) { list, error ->
            list?.apply {
                _pullRequests.value = this
            }

            error?.apply {
                _error.value = this
            }
        }
    }

}