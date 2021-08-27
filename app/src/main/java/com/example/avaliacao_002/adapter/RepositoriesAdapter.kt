package com.example.avaliacao_002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avaliacao_002.R
import com.example.avaliacao_002.databinding.ItemRepositoryBinding
import com.example.avaliacao_002.model.Repository

class RepositoriesAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {

    private val repositoriesList: List<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        repositoriesList[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = repositoriesList.size
}

class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: ItemRepositoryBinding = ItemRepositoryBinding.bind(itemView)

    fun bind(repository: Repository) {
        repository.owner.let {
            Glide.with(itemView.context).load(it.avatarURL)
                .into(binding.repositoryOwnerAvatarImageView)
        }

        repository.let {
            binding.repositoryTitleTextView.text = it.fullName
            binding.descriptionTextView.text = it.description
            binding.forkTextView.text = it.forksCount.toString()
            binding.starTextView.text = it.starsCount.toString()
        }
    }

}