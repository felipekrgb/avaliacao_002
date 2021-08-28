package com.example.avaliacao_002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avaliacao_002.R
import com.example.avaliacao_002.view_model.PullRequestsViewModel

class PullRequestsFragment : Fragment() {

    companion object {
        fun newInstance() = PullRequestsFragment()
    }

    private lateinit var viewModel: PullRequestsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.pull_requests_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullRequestsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}