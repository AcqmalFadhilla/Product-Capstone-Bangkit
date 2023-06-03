package com.reev.telokkaapps.ui.dashboard.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.CategoryDataSource
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.databinding.FragmentHomeBinding
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.CategoryListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.ItemListAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // untuk list kategori
        binding.layoutHomeFragment.listCategory.sectionTitle.text = "Ingin menelusuri wisata lainnya?"
        val dummyCategory = CategoryDataSource.dummyCategories
        val categoryListAdapter = CategoryListAdapter(dummyCategory)

        binding.layoutHomeFragment.listCategory.itemRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryListAdapter
        }

        // untuk item list
        binding.layoutHomeFragment.listPlaceLayout.sectionTitle.text = "Tempat rekomendasi untuk anda"

        val dummyPlace = DummyPlacesData.dummyPlaces
        val placeListAdapter = ItemListAdapter(dummyPlace)

        binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = placeListAdapter
        }
    }
}
