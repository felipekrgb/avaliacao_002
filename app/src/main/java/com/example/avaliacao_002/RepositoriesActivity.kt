package com.example.avaliacao_002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliacao_002.view.RepositoriesFragment

class RepositoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportActionBar?.hide()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RepositoriesFragment.newInstance())
                .commitNow()
        }
    }
}