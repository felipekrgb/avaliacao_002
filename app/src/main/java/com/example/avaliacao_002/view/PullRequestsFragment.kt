package com.example.avaliacao_002.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avaliacao_002.R
import com.example.avaliacao_002.adapter.PullRequestAdapter
import com.example.avaliacao_002.adapter.RepositoriesAdapter
import com.example.avaliacao_002.databinding.PullRequestsFragmentBinding
import com.example.avaliacao_002.model.PullRequest
import com.example.avaliacao_002.model.Repository
import com.example.avaliacao_002.view_model.PullRequestsViewModel

class PullRequestsFragment : Fragment(R.layout.pull_requests_fragment) {

    private lateinit var binding: PullRequestsFragmentBinding
    private lateinit var viewModel: PullRequestsViewModel
    private lateinit var repository: Repository
    private lateinit var recyclerView: RecyclerView

    private var adapter = PullRequestAdapter() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
        startActivity(intent)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getSerializable("repository")?.let {
            repository = it as Repository
        }
    }

    companion object {
        fun newInstance(repository: Repository): PullRequestsFragment {
            return PullRequestsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("repository", repository)
                }
            }
        }
    }

    private val pullRequestsObserver = Observer<List<PullRequest>> { pullRequestsList ->
        adapter.update(pullRequestsList)
        binding.progressBar.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PullRequestsFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(PullRequestsViewModel::class.java)


        recyclerView = binding.pullRequestsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.pullRequests.observe(viewLifecycleOwner, pullRequestsObserver)
        viewModel.getPullRequestsList(repository.fullName)

        repository?.let {
            binding.repositoryNameTextView.text = it.fullName
            binding.repositoryDescriptionTextView.text = it.description
        }

        repository.owner?.let {
            Glide.with(this).load(it.avatarURL)
                .into(binding.repositoryOwnerAvatarImageView)
        }
    }

}