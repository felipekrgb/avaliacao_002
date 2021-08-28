package com.example.avaliacao_002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avaliacao_002.R
import com.example.avaliacao_002.databinding.ItemPullRequestBinding
import com.example.avaliacao_002.model.PullRequest
import com.example.avaliacao_002.model.Repository

class PullRequestAdapter : RecyclerView.Adapter<PullRequestViewHolder>() {

    private var pullRequestsList: MutableList<PullRequest> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pull_request, parent, false)
        return PullRequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        pullRequestsList[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = pullRequestsList.size

    fun update(newList: List<PullRequest>) {
        pullRequestsList = mutableListOf()
        pullRequestsList.addAll(newList)
        notifyDataSetChanged()
    }
}

class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: ItemPullRequestBinding = ItemPullRequestBinding.bind(itemView)

    fun bind(pullRequest: PullRequest) {
        pullRequest.let {
            binding.pullRequestTitleTextView.text = it.title
        }

        pullRequest.user.let {
            Glide.with(itemView.context).load(it.avatarURL)
                .into(binding.userAvatarImageView)
        }
    }

}