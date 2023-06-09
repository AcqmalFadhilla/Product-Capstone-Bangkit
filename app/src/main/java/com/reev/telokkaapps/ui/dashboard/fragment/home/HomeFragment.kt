package com.reev.telokkaapps.ui.dashboard.fragment.home

import android.Manifest
import android.app.Application
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
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.CategoryDataSource
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.databinding.FragmentHomeBinding
import com.reev.telokkaapps.ui.dashboard.MainViewModel
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.CategoryItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.minimap.MinimapFragment


class HomeFragment : Fragment(){

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var minimapFragment: MinimapFragment

    // variable untuk getLastLocation
    private lateinit var fusedLocation: FusedLocationProviderClient
    private var latestLatitude: Double = 0.0
    private var latestLongitude: Double = 0.0

    companion object {
        private const val CUR_LOC_PERMISSION_REQUEST_CODE = 1001 // untuk getLastLocation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = MainViewModel(context?.applicationContext as Application)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set minimap
        minimapFragment = MinimapFragment()
        childFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, minimapFragment)
            .commit()

        // Untuk track posisi user saat ini
        viewModel.getLatestLocation().observe(viewLifecycleOwner, {
            if (it != null) {
                latestLatitude = it.latitude
                latestLongitude = it.longitude

                val locationText = StringBuilder().apply {
                    append(latestLatitude)
                    append(", ")
                    append(latestLongitude)
                }.toString()
                binding.layoutHomeFragment.minimapLayout.curLocationTV.text = locationText
            }
        })

        // update pin minimap
        fusedLocation = LocationServices.getFusedLocationProviderClient(requireActivity())
        fusedLocation.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null && location.latitude != null && location.longitude != null) {
                if (latestLatitude == location.latitude && latestLongitude == location.longitude){
                    //buat update location di minimap
                    minimapFragment.updateMapLocation(location.latitude, location.longitude)
                }
            }
            Toast.makeText(requireContext(), getString(R.string.please_update_your_location), Toast.LENGTH_SHORT).show()
        }


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
                fusedLocation = LocationServices.getFusedLocationProviderClient(requireActivity())
                fusedLocation.lastLocation.addOnSuccessListener { location: Location? ->
                    if (location != null && location.latitude != null && location.longitude != null) {
                        if (latestLatitude == location.latitude && latestLongitude == location.longitude){
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.location_is_up_to_date),
                                Toast.LENGTH_SHORT
                            ).show()
                            //buat update location di minimap
                            minimapFragment.updateMapLocation(location.latitude, location.longitude)

                        }else{
                            viewModel.insertNewLocationHistory(
                                LocationHistory(
                                    0,
                                    latitude = location.latitude,
                                    longitude = location.longitude,
                                )
                            )
                            //buat update location di minimap
                            minimapFragment.updateMapLocation(location.latitude, location.longitude)
                        }
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
        binding.layoutHomeFragment.listCategory.sectionTitle.text = getString(R.string.home_category_section)
        val dummyCategory = CategoryDataSource.dummyCategories
        val categoryItemListAdapter = CategoryItemListAdapter(dummyCategory)

        binding.layoutHomeFragment.listCategory.itemRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryItemListAdapter
        }

        viewModel.getAllTourismCategories().observe(viewLifecycleOwner, {
            val categoryItemListAdapter = CategoryItemListAdapter(it)

            binding.layoutHomeFragment.listCategory.itemRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = categoryItemListAdapter
            }
        })

        // untuk item list
        binding.layoutHomeFragment.listPlaceLayout.sectionTitle.text = getString(R.string.home_place_list_section)

        viewModel.getPlaceTourismAndCategory().observe( viewLifecycleOwner, {
            val placeListAdapter = PlaceItemListAdapter(it)

            binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = placeListAdapter
            }
        })

    }

}
