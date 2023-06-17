package com.reev.telokkaapps.ui.dashboard.fragment.home.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.databinding.ItemPlaceBinding
import com.reev.telokkaapps.ui.detail.DetailActivity
import com.reev.telokkaapps.utility.Constant

class PlaceItemPagingAdapter : PagingDataAdapter<TourismPlaceItem, PlaceItemPagingAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }


    class MyViewHolder(private val binding: ItemPlaceBinding) :
        RecyclerView.ViewHolder(binding.root) {
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

                placeCardView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(Constant.DETAIL_PLACE, item.placeId)
                    }
                    itemView.context.startActivity(intent)
                }
            }

        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TourismPlaceItem>() {
            override fun areItemsTheSame(oldItem: TourismPlaceItem, newItem: TourismPlaceItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: TourismPlaceItem, newItem: TourismPlaceItem): Boolean {
                return oldItem.placeId == newItem.placeId
            }
        }
    }
}