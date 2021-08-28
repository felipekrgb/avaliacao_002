package com.example.avaliacao_002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.avaliacao_002.databinding.PullRequestsActivityBinding
import com.example.avaliacao_002.model.Repository
import com.example.avaliacao_002.view.PullRequestsFragment

class PullRequestsActivity : AppCompatActivity() {

    private lateinit var binding: PullRequestsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PullRequestsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        println("ENNTROUUUUUUUU NO ACTIVITY DE PULLLL REQUEST")
        val repository = intent.getSerializableExtra("repository") as Repository
        println(repository)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PullRequestsFragment.newInstance(repository))
            .commitNow()

    }
}