package com.example.avaliacao_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avaliacao_002.model.Repository
import com.example.avaliacao_002.repository.GithubRepository

class RepositoriesViewModel : ViewModel() {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> = _repositories

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val githubRepository = GithubRepository()

    fun getRepositoriesList() {
        githubRepository.getRepositoriesList { list, error ->
            list?.apply {
                _repositories.value = this
            }

            error?.apply {
                _error.value = this
            }
        }
    }

}