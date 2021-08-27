package com.example.avaliacao_002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.avaliacao_002.R
import com.example.avaliacao_002.view_model.RepositoriesViewModel

class RepositoriesFragment : Fragment(R.layout.repositories_fragment) {

    companion object {
        fun newInstance() = RepositoriesFragment()
    }

    private lateinit var viewModel: RepositoriesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)
    }

}