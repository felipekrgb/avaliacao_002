package com.example.avaliacao_002.view

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliacao_002.PullRequestsActivity
import com.example.avaliacao_002.R
import com.example.avaliacao_002.adapter.RepositoriesAdapter
import com.example.avaliacao_002.databinding.RepositoriesFragmentBinding
import com.example.avaliacao_002.model.Repository
import com.example.avaliacao_002.view_model.RepositoriesViewModel

class RepositoriesFragment : Fragment(R.layout.repositories_fragment) {

    private lateinit var binding: RepositoriesFragmentBinding
    private lateinit var viewModel: RepositoriesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterSpinner: ArrayAdapter<String>
    private var adapter = RepositoriesAdapter() { repository ->
        val intentToPullRequests =
            Intent(activity?.applicationContext, PullRequestsActivity::class.java)
        intentToPullRequests.putExtra("repository", repository)
        startActivity(intentToPullRequests)
    }

    companion object {
        fun newInstance() = RepositoriesFragment()
    }

    private val repositoriesObserver = Observer<List<Repository>> { repositoriesList ->
        adapter.update(repositoriesList)
        binding.progressBar.visibility = View.GONE
        binding.repositoriesRecyclerView.visibility = View.VISIBLE
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RepositoriesFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        setupSpinner()

        recyclerView = binding.repositoriesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.repositories.observe(viewLifecycleOwner, repositoriesObserver)
        viewModel.getRepositoriesList("Java")
    }

    fun setupSpinner() {
        val listOfLanguages =
            listOf("Java", "Kotlin", "Ruby", "JavaScript", "Python", "Assembly", "Dart", "C", "PHP", "Go")
        adapterSpinner =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_item_languages, listOfLanguages)


        val autoCompleteBrand: AutoCompleteTextView? =
            binding.linguagemTextInputLayout.editText as? AutoCompleteTextView

        autoCompleteBrand?.setAdapter(adapterSpinner)

        autoCompleteBrand?.setOnItemClickListener { parent, view, position, id ->
            val selected = parent.getItemAtPosition(position) as String

            binding.progressBar.visibility = View.VISIBLE
            binding.repositoriesRecyclerView.visibility = View.GONE

            val imm =
                requireActivity().window.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireActivity().window.decorView.windowToken, 0)

            viewModel.getRepositoriesList(selected)
        }
    }

}