package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.relation.PlaceAndTourismCategory
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.FragmentExploreBinding
import com.reev.telokkaapps.helper.InitialDataSource
import com.reev.telokkaapps.ui.dashboard.fragment.explore.adapter.SearchItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.explore.filtering.FilteringFragment
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemListAdapter
import com.reev.telokkaapps.ui.detail.DetailActivity


class ExploreFragment : Fragment(){
    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewModel: ExploreViewModel

    override fun onResume() {
        super.onResume()
        val placeNameOptions = InitialDataSource.getTourismPlaceNames()
        val placeNameAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown_search, placeNameOptions)
        binding.apply {
            itemSearchBanner.searchTextField.setAdapter(placeNameAdapter)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        viewModel = ExploreViewModel(context?.applicationContext as Application)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // untuk filter
        val filteringFragment = FilteringFragment()

        binding.itemSearchBanner.filterButton.setOnClickListener {
            // buat aksi untuk memunculkan item filter
            Toast.makeText(requireContext(), "Buka Filter", Toast.LENGTH_SHORT).show()
            filteringFragment.show(childFragmentManager, "FilteringDialog")
        }

        // untuk item list
        binding.listSearchPlaceLayout.sectionTitle.text = "Hasil Pencarian"

        viewModel.getPlaceTourismAndCategory().observe(viewLifecycleOwner, {
            val placeListAdapter = PlaceItemListAdapter(it)

            binding.listSearchPlaceLayout.itemRecyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                adapter = placeListAdapter
            }
        })

    }

}