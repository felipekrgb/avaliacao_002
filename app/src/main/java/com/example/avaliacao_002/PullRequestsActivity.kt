package com.example.avaliacao_002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliacao_002.view.PullRequestsFragment

class PullRequestsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_requests_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PullRequestsFragment.newInstance())
                .commitNow()
        }
    }
}