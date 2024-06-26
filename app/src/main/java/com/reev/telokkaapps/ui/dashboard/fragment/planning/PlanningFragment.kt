package com.reev.telokkaapps.ui.dashboard.fragment.planning

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.local.database.model.TourismPlanItem
import com.reev.telokkaapps.data.source.local.dummy.dummyplanning.DummyPlanning
import com.reev.telokkaapps.data.source.local.dummy.dummyplanning.PlanningPlace
import com.reev.telokkaapps.databinding.FragmentExploreBinding
import com.reev.telokkaapps.databinding.FragmentPlanningBinding
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.CategoryItemListAdapter
import com.reev.telokkaapps.ui.dashboard.fragment.planning.adapter.PlanningItemListAdapter
import com.reev.telokkaapps.ui.detail.DetailActivity
import com.reev.telokkaapps.ui.detailplanning.DetailPlanningActivity

class PlanningFragment : Fragment(), PlanningItemListAdapter.OnDeleteItemClickListener{

    private lateinit var binding: FragmentPlanningBinding
    private lateinit var viewModel: PlanningViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlanningBinding.inflate(inflater, container, false)
        viewModel = PlanningViewModel(context?.applicationContext as Application)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // untuk item list
        binding.listPlanningLayout.sectionTitle.text = "Jadwal Kegiatan Wisata Anda"

        updateData()
    }
    override fun onDeleteClick(plan: TourismPlanItem) {
        viewModel.deleteTourismPlanWithId(plan.planId)
        updateData()
    }
    private fun updateData(){
        viewModel.getAllPlanWithPlaceAndTourismCategory().observe(viewLifecycleOwner, {
            val planningListAdapter = PlanningItemListAdapter(it, this)

            binding.listPlanningLayout.itemRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = planningListAdapter
            }
        })

    }
}