package com.reev.telokkaapps.ui.dashboard.fragment.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.databinding.ItemPlaceBinding

class PlaceItemListAdapter(private val dataList: List<TourismPlaceItem>, private val listener: OnPlaceItemClickListener) :
    RecyclerView.Adapter<PlaceItemListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemPlaceBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val place = dataList[position]
                    listener.onPlaceItemClick(place)
                }
            }
        }

        fun bind(item: TourismPlaceItem) {
            binding.apply{

                val color = ContextCompat.getColor(binding.root.context ,R.color.blue_200)

                val drawable = CircularProgressDrawable(binding.root.context)
                drawable.strokeWidth = 10f
                drawable.centerRadius = 50f
                drawable.setColorSchemeColors(color)
                drawable.start()

                Glide.with(itemView.context)
                    .load(item.placePhotoUrl)
                    .placeholder(drawable)
                    .into(placeImg)

                placeName.text = item.placeName
                placeCategory.text = item.placeCategory
                placeRating.text = item.placeRating.toString()
            }
        }
    }

    interface  OnPlaceItemClickListener {
        fun onPlaceItemClick(place: TourismPlaceItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding = ItemPlaceBinding.inflate(inflater, parent, false)
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