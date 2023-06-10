package com.reev.telokkaapps.ui.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.QuoteDatabase
import com.reev.telokkaapps.data.repository.QuoteRepository
import com.reev.telokkaapps.databinding.ActivityTestingApiBinding
import com.reev.telokkaapps.ui.detail.DetailActivity

class TestingApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestingApiBinding
    private val viewModel: TestViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvQuote.layoutManager = LinearLayoutManager(this)

        getData()
        binding.floatingActionButton.setOnClickListener{
            var newIntent = Intent(this, DetailActivity::class.java)
            startActivity(newIntent)
        }
    }

    private fun getData() {
        val adapter = QuoteListAdapter()
        binding.rvQuote.adapter = adapter
        viewModel.quote.observe(this, {
            Log.i("dataResponse", "Datanya : ${it}")
            adapter.submitData(lifecycle,it)
        })
    }
}