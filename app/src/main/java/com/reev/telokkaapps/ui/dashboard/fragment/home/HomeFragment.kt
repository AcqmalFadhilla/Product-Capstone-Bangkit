package com.reev.telokkaapps.ui.dashboard.fragment.home

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.CategoryDataSource
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData
import com.reev.telokkaapps.databinding.FragmentHomeBinding
import com.reev.telokkaapps.helper.InternetConnection
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.CategoryItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemPagingAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.home.minimap.MinimapFragment


class HomeFragment : Fragment(){

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var placePagingAdapter: PlaceItemPagingAdapter
    private lateinit var placeListAdapter : PlaceItemListAdapter

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
        viewModel = HomeViewModel(context?.applicationContext as Application)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placePagingAdapter = PlaceItemPagingAdapter()

        // set minimap
        minimapFragment = MinimapFragment()
        childFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, minimapFragment)
            .commit()

        // Mendapatkan riwayat lokasi terakhir dari database
        viewModel.getLatestLocation().observe(viewLifecycleOwner, {
            if (it != null) {
                latestLatitude = it.latitude
                latestLongitude = it.longitude

                minimapFragment.updateMapLocation(latestLatitude, latestLongitude)


                val locationText = StringBuilder().apply {
                    append(latestLatitude)
                    append(", ")
                    append(latestLongitude)
                }.toString()
                binding.layoutHomeFragment.minimapLayout.curLocationTV.text = locationText
                updateTourismPlaceRecomended()
            }
        })


        // Menambahkan aksi ketika tombol update lokasi di klik
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
                    if (location?.latitude != null && location.longitude != null) {
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


        // Mendapatkan list kategori
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


        // Mendapatkan
        binding.layoutHomeFragment.listPlaceLayout.sectionTitle.text = getString(R.string.home_place_list_section)

        val dummyPlace = DummyPlacesData.dummyPlaces2
        val placeListAdapter = PlaceItemListAdapter(dummyPlace)
        binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = placeListAdapter
        }

    }
    private fun updateTourismPlaceRecomended() {
        Log.i("dataResponse", "Masuk ke  fungsi updateTourismPlaceRecomended()")
        if (InternetConnection.checkConnection(requireContext())){
                Log.i("dataResponse", "Ada Akses Internet")
                if (latestLongitude == 0.0 && latestLatitude == 0.0 ){
                    Log.i("dataResponse", "Ada Akses Internet dan lati dan long = 0")
                    // Mendapatkan tempat wisata berdasarkan kategori favorite dari Cloud API
                    getDataTourismPlaceWithFavoriteCategoryOnline()

                }else {
                    Log.i("dataResponse", "Ada Akses Internet dan lati dan long bukan 0")
                    // Mendapatkan tempat wisata hasil rekomendasi dari Cloud API
                    getDataTourismPlaceRecommendedOnline()
                }
            }else{
                Log.i("dataResponse", "Tidak Ada Akses Internet")

                if (latestLongitude == 0.0 && latestLatitude == 0.0 ) {
                    Log.i("dataResponse", "Tidak Ada Akses Internet dan lat dan ,lon = 0")
                    // mendapatkan tempat berdasarkan kategori favorite dari database
                    getDataTourismPlaceWithFavoriteCategoryOffline()


                }else{
                    Log.i("dataResponse", "Tidak Ada Akses Internet dan lat dan ,lon bukan 0")
                    // mendapatkan tempat rekomendasi dari database
                    getDataTourismPlaceRecommendedOffline()
                }
            }

    }
    private fun getDataTourismPlaceRecommendedOffline(){
        Log.i("dataResponse", "Masuk ke getDataTourismPlaceRecommendedOffline()" )
        viewModel.getTourismPlaceRecomended().observe(viewLifecycleOwner, {
            placeListAdapter = PlaceItemListAdapter(it)
            binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = placeListAdapter
            }
        })

    }
    private fun getDataTourismPlaceRecommendedOnline(){
        placePagingAdapter = PlaceItemPagingAdapter()
        binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.adapter = placePagingAdapter
        viewModel.getNewTourismPlaceRecomended(
            latitude = latestLatitude,
            longitude = latestLongitude
        ).observe(viewLifecycleOwner, { data ->
//                        Log.i("dataResponse", "Data : $data")
            placePagingAdapter.addLoadStateListener {loadState->
                val isNotLoading = when {
                    loadState.append is LoadState.NotLoading -> true
                    loadState.prepend is LoadState.NotLoading ->  true
                    loadState.refresh is LoadState.NotLoading -> true
                    else -> false
                }
                isNotLoading.let {
                    if (isNotLoading) {
                        placePagingAdapter.submitData(lifecycle, data)
                    }
                }
            }

        })

    }
    private fun getDataTourismPlaceWithFavoriteCategoryOffline(){
        getDataTourismPlaceRecommendedOffline()
    }
    private fun getDataTourismPlaceWithFavoriteCategoryOnline(){
        viewModel.getTourismCategoriesFavorited().observe(viewLifecycleOwner, {
            viewModel.getNewTourismPlaceWithCategory(it.categoryName).observe(viewLifecycleOwner, { data->
                placePagingAdapter.submitData(lifecycle, data)
                placePagingAdapter.addLoadStateListener { loadState ->
                    val isNotLoading = when {
                        loadState.append is LoadState.NotLoading -> true
                        loadState.prepend is LoadState.NotLoading ->  true
                        loadState.refresh is LoadState.NotLoading -> true
                        else -> false
                    }
                    isNotLoading.let {
                        if (isNotLoading) {
                            binding.layoutHomeFragment.listPlaceLayout.itemRecyclerView.apply {
                                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                adapter = placePagingAdapter

                                placePagingAdapter.submitData(lifecycle, data)
                            }
                        }
                    }
                }
            })

        })

    }

}