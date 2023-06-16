package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.reev.telokkaapps.R
import com.reev.telokkaapps.databinding.FragmentExploreBinding
import com.reev.telokkaapps.helper.InitialDataSource
import com.reev.telokkaapps.helper.InternetConnection
import com.reev.telokkaapps.ui.dashboard.fragment.explore.adapter.SearchItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.explore.filtering.FilteringFragment
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemPagingAdapter


class ExploreFragment : Fragment(){
    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewModel: ExploreViewModel
    private lateinit var placePagingAdapter: PlaceItemPagingAdapter
    private lateinit var placeListAdapter : SearchItemListAdapter
    private lateinit var filteringFragment : FilteringFragment


    // data filter
    private var city : String? = null
    private var idCategory : Int? = null
    private var orderRating : Boolean? = null
    private var searchText : String = ""



    private var lastPage : Int = 0

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

        placePagingAdapter = PlaceItemPagingAdapter()

        binding.apply{// untuk filter
            filteringFragment = FilteringFragment()

            itemSearchBanner.filterButton.setOnClickListener {
                // buat aksi untuk memunculkan item filter
                Toast.makeText(requireContext(), "Buka Filter", Toast.LENGTH_SHORT).show()
                filteringFragment.show(childFragmentManager, "FilteringDialog")
            }


            // untuk item list
            listSearchPlaceLayout.sectionTitle.text = "Hasil Pencarian"

            // Aksi ketika ikon search diklik
            itemSearchBanner.searchField.setStartIconOnClickListener {
                searchingHandler()
            }

            itemSearchBanner.searchTextField.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Tambahkan aksi kustom di sini
                    searchingHandler()

                    // Menutup keyboard
                    val inputMethodManager =
                        requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                    true
                } else {
                    false
                }
            }
        }
//        childFragmentManager.setFragmentResultListener(FILTERING_DATA, this){key, bunddle->
//            idCategory = bunddle.getInt("idCategory")
//            city = bunddle.getString("city")
//            orderRating = bunddle.getBoolean("city")
//
//        }

    }

    private fun searchingHandler(){
        Toast.makeText(requireContext(), "Mencari...", Toast.LENGTH_SHORT).show()

        city = filteringFragment.city
        idCategory = filteringFragment.idCategory
        orderRating = filteringFragment.orderRating
        searchText = binding.itemSearchBanner.searchTextField.text.toString()

        Log.i("dataFilter", "EF city = $city" )
        Log.i("dataFilter", "EF categoryId = ${idCategory.toString()}" )
        Log.i("dataFilter", "EF orderRating = $orderRating" )



        if (searchText.isEmpty()){
            Toast.makeText(requireContext(), "Silahkan masukkan tempat wisata atau aktivitas yang ingin Anda cari!", Toast.LENGTH_SHORT).show()
        }else {
            getNewData(
                query = searchText,
                idCategory = idCategory,
                city = city,
                orderRating = orderRating
            )
        }
    }

    private fun getNewData(query : String, idCategory: Int?, city : String?, orderRating: Boolean?){
        lastPage++
        if (InternetConnection.checkConnection(requireContext())){
            viewModel.getNewTourismPlaceSearched(query, idCategory, city, orderRating)
                .observe(viewLifecycleOwner, {data->
                    binding.listSearchPlaceLayout.itemRecyclerView.apply {
                        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                        adapter = placePagingAdapter
                        placePagingAdapter.submitData(lifecycle, data)

                    }
                })
        }else{
            // Tampilan ketika offline
            viewModel.getPlaceTourismAndCategory().observe(viewLifecycleOwner, {
                placeListAdapter = SearchItemListAdapter(it)

                binding.listSearchPlaceLayout.itemRecyclerView.apply {
                    layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    adapter = placeListAdapter
                }
            })
        }

    }

    companion object{
        public val FILTERING_DATA : String = "filter_request_key"
    }



}