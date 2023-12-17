package com.reev.telokkaapps.ui.categoryzation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.Category
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.CategoryDataSource
import com.reev.telokkaapps.databinding.ActivityCategoryzationBinding
import com.reev.telokkaapps.ui.categoryzation.adapter.CategoryzationItemListAdapter
import com.reev.telokkaapps.ui.dashboard.MainActivity
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.CategoryItemListAdapter

class CategoryzationActivity : AppCompatActivity(),
    CategoryzationItemListAdapter.OnCategoryItemClickListener {
    private lateinit var binding: ActivityCategoryzationBinding
    private lateinit var viewModel: CategoryzationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryzationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CategoryzationViewModel(application)

        // Mendapatkan data kategori dari database tourism
        viewModel.getAllCategories().observe(this, {
            val categoryItemListAdapter = CategoryzationItemListAdapter(it, this)

            binding.itemRecyclerView.apply {
                layoutManager = GridLayoutManager(this@CategoryzationActivity, 2, GridLayoutManager.VERTICAL, false)
                adapter = categoryItemListAdapter
            }

        })
    }

    override fun onCategoryClick(category: TourismCategory) {
        val alertDialog = android.app.AlertDialog.Builder(this@CategoryzationActivity)
            .setTitle("Pastikan memilih kategori minat anda dengan benar")
            .setMessage("Aplikasi akan memberikan rekomendasi berdasarkan kategori yang anda minati")
            .setPositiveButton("Ya, lanjut") { _, _ ->
                viewModel.updateFavoriteStatusOfTourismCategory(id = category.categoryId, true)
                Toast.makeText(this@CategoryzationActivity, "Kategori ${category.categoryName} dipilih", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("pilih kembali", null)
            .create()
        alertDialog.show()
    }
}