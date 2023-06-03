package com.reev.telokkaapps.ui.dashboard.fragment.home

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.CategoryDataSource
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.databinding.FragmentHomeBinding
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.CategoryListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.ItemListAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    // variable untuk getCurLocation
    private var latitude: Double? = null
    private var longitude: Double? = null
    private lateinit var fusedLocation: FusedLocationProviderClient

    companion object {
        private const val CUR_LOC_PERMISSION_REQUEST_CODE = 1001 // untuk getCurLocation
    }

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

        // Untuk track posisi user saat ini
        fusedLocation = LocationServices.getFusedLocationProviderClient(requireActivity())

        binding.layoutHomeFragment.minimapLayout.btnUpdateLocation.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    CUR_LOC_PERMISSION_REQUEST_CODE
                )
            } else {
                fusedLocation.lastLocation.addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        latitude = location.latitude
                        longitude = location.longitude
                        val locationText = StringBuilder().apply {
                            append(latitude)
                            append(", ")
                            append(longitude)
                        }.toString()
                        binding.layoutHomeFragment.minimapLayout.curLocationTV.text = locationText
                    } else {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.location_not_found),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }



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
