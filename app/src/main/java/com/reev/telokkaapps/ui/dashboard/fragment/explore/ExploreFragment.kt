package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.app.Application
import android.content.Context
import android.os.Bundle
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

    }

    private fun searchingHandler(){
        Toast.makeText(requireContext(), "Mencari...", Toast.LENGTH_SHORT).show()

        val city = filteringFragment.city
        val category = filteringFragment.category
        val orderRating = filteringFragment.orderRating
        val searchText = binding.itemSearchBanner.searchTextField.text.toString()

        getNewData(
            query = searchText,
            category = category,
            city = city,
            orderRating = orderRating
        )
    }

    private fun getNewData(query : String, category: String, city : String, orderRating: Boolean){
        lastPage++
        if (InternetConnection.checkConnection(requireContext())){
            viewModel.getNewTourismPlaceSearched(query, category, city, orderRating)
                .observe(viewLifecycleOwner, {data->
                    placePagingAdapter.submitData(lifecycle, data)
                    placePagingAdapter.addLoadStateListener { loadState ->
                        val isError : Boolean = when {
                            loadState.append is LoadState.Error -> true
                            loadState.prepend is LoadState.Error ->  true
                            loadState.refresh is LoadState.Error -> true
                            else -> false
                        }
                        isError.let {
                            if (!isError) {
                                binding.listSearchPlaceLayout.itemRecyclerView.apply {
                                    layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                    adapter = placePagingAdapter
                                }
                            }
                        }
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


}