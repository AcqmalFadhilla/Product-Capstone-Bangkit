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
import androidx.core.view.isVisible
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

        initPagingAdapter()

        binding.apply{// untuk filter
            filteringFragment = FilteringFragment()


            itemSearchBanner.filterButton.setOnClickListener {
                // buat aksi untuk memunculkan item filter
                filteringFragment.show(childFragmentManager, "FilteringDialog")
            }

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

        if (arguments != null) {
            val categoryidd = arguments?.getInt(ID_CATEGORY_TO_SHOW)
            val categoryNamee = arguments?.getString(NAME_CATEGORY_TO_SHOW)
            // untuk item list
            if (categoryidd != null && categoryNamee != null) {
                if (InternetConnection.checkConnection(requireContext())) {
                    binding.tvMessageNotFound1.visibility = View.GONE
                    viewModel.getNewTourismPlaceWithCategory(category = categoryNamee, idCategory = categoryidd)
                        .observe(viewLifecycleOwner, { data ->

                            binding.listSearchPlaceLayout.itemRecyclerView.apply {
                                layoutManager = StaggeredGridLayoutManager(
                                    2,
                                    StaggeredGridLayoutManager.VERTICAL
                                )
                                adapter = placePagingAdapter
                                placePagingAdapter.submitData(lifecycle, data)
                            }

                        })
                }else{
                    binding.listSearchPlaceLayout.itemRecyclerView.visibility = View.GONE
                    binding.listSearchPlaceLayout.sectionTitle.visibility = View.GONE
                    binding.tvMessageNotFound1.visibility = View.VISIBLE
                }
            }

            binding.listSearchPlaceLayout.sectionTitle.text = "Kategori $categoryNamee"
        }else{
            binding.tvMessageNotFound1.visibility = View.GONE
            binding.listSearchPlaceLayout.itemRecyclerView.visibility = View.VISIBLE
            binding.listSearchPlaceLayout.sectionTitle.text = "Hasil Pencarian"
            binding.listSearchPlaceLayout.sectionTitle.visibility = View.VISIBLE

        }

    }

    private fun searchingHandler(){
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
            // untuk item list
            binding.tvMessageNotFound1.visibility = View.GONE
            binding.listSearchPlaceLayout.itemRecyclerView.visibility = View.VISIBLE
            binding.listSearchPlaceLayout.sectionTitle.text = "Hasil Pencarian"
            binding.listSearchPlaceLayout.sectionTitle.visibility = View.VISIBLE


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
    private fun initPagingAdapter(){
        placePagingAdapter = PlaceItemPagingAdapter()
        placePagingAdapter.addLoadStateListener {loadState->
            binding.listSearchPlaceLayout.itemRecyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
            binding.listSearchPlaceLayout.progressBarHome.isVisible = loadState.source.refresh is LoadState.Loading
        }
    }

    companion object{
        public val ID_CATEGORY_TO_SHOW : String = "id_category_to_show"
        public val NAME_CATEGORY_TO_SHOW : String = "name_category_to_show"
    }



}