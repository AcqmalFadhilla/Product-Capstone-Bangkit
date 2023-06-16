package com.reev.telokkaapps.ui.favoriteplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.databinding.ActivityFavoritePlaceBinding
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemListAdapter
import com.reev.telokkaapps.ui.favoriteplace.adapter.FavoritePlaceListAdapter

class FavoritePlaceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoritePlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritePlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menampilkan tombol kembali di action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // untuk item list
        binding.listPlanningLayout.sectionTitle.text = "Daftar Wisata Favorit Anda"

        val dummyPlace = DummyPlacesData.dummyPlaces
        val placeListAdapter = FavoritePlaceListAdapter(dummyPlace)

        binding.listPlanningLayout.itemRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = placeListAdapter
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Menangani kembali ketika tombol kembali di action bar ditekan
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}