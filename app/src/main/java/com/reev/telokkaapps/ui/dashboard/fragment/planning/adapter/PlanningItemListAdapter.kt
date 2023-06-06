package com.reev.telokkaapps.ui.dashboard.fragment.planning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummyplanning.PlanningPlace
import com.reev.telokkaapps.databinding.ItemPlanningBinding

class PlanningItemListAdapter(private val dataList: List<PlanningPlace>, private val listener: OnPlaceItemClickListener) :
    RecyclerView.Adapter<PlanningItemListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemPlanningBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val planningPlace = dataList[position]
                    listener.onPlanningItemClick(planningPlace)
                }
            }
        }

        fun bind(item: PlanningPlace) {
            binding.apply{

                val color = ContextCompat.getColor(binding.root.context , R.color.blue_200)

                val drawable = CircularProgressDrawable(binding.root.context)
                drawable.strokeWidth = 10f
                drawable.centerRadius = 50f
                drawable.setColorSchemeColors(color)
                drawable.start()

                Glide.with(itemView.context)
                    .load(item.place.placePhotoUrl)
                    .placeholder(drawable)
                    .into(placeImg)

                planningTitleTextView.text = item.title

                //set tujuan dan jadwal
                val placeName = item.place.placeName
                val date = item.date
                placeNameTextView.text = "Tujuan : $placeName"
                planningDateTextView.text = "Jadwal : $date"
            }
        }
    }

    interface  OnPlaceItemClickListener {
        fun onPlanningItemClick(planningPlace: PlanningPlace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding = ItemPlanningBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }
}