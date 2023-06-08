package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.relation.PlaceAndTourismCategory
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.FragmentExploreBinding
import com.reev.telokkaapps.ui.dashboard.fragment.explore.adapter.SearchItemListAdapter
import com.reev.telokkaapps.ui.detail.DetailActivity


class ExploreFragment : Fragment(),
    SearchItemListAdapter.OnPlaceItemClickListener{
    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // untuk filter
        binding.itemSearchBanner.filterButton.setOnClickListener {
            // buat aksi untuk memunculkan item filter
            Toast.makeText(requireContext(), "Buka Filter", Toast.LENGTH_SHORT).show()
        }

        // untuk item list
        binding.listSearchPlaceLayout.sectionTitle.text = "Hasil Pencarian"

        val dummyPlace = DummyPlacesData.dummyPlaces
        val placeListAdapter = SearchItemListAdapter(dummyPlace, this)

        binding.listSearchPlaceLayout.itemRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            adapter = placeListAdapter
        }

    }

    override fun onPlaceItemClick(place: PlaceAndTourismCategory) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("PLACE_EXTRA", place)
        startActivity(intent)
    }

}