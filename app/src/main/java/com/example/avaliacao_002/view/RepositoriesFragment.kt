package com.example.avaliacao_002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliacao_002.R
import com.example.avaliacao_002.adapter.RepositoriesAdapter
import com.example.avaliacao_002.databinding.RepositoriesFragmentBinding
import com.example.avaliacao_002.model.Repository
import com.example.avaliacao_002.view_model.RepositoriesViewModel

class RepositoriesFragment : Fragment(R.layout.repositories_fragment) {

    private lateinit var binding: RepositoriesFragmentBinding

    companion object {
        fun newInstance() = RepositoriesFragment()
    }

    private lateinit var viewModel: RepositoriesViewModel

    private lateinit var recyclerView: RecyclerView
    private var adapter = RepositoriesAdapter()

    private val repositoriesObserver = Observer<List<Repository>> { repositoriesList ->
        adapter.update(repositoriesList)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RepositoriesFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        recyclerView = binding.repositoriesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.repositories.observe(viewLifecycleOwner, repositoriesObserver)
        viewModel.getRepositoriesList()
    }

}