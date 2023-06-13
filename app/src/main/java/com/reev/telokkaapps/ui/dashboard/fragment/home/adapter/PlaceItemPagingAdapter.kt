package com.reev.telokkaapps.ui.dashboard.fragment.home.adapter

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
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import com.reev.telokkaapps.databinding.ItemPlaceBinding

class PlaceItemPagingAdapter : PagingDataAdapter<ListPlaceItem, PlaceItemPagingAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int  = 20

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position > 0) {
            val data = getItem(position)
            if (data != null) {
                holder.bind(data)
            }
        }
    }


    class MyViewHolder(private val binding: ItemPlaceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListPlaceItem) {
            binding.apply{

                val color = ContextCompat.getColor(binding.root.context ,R.color.blue_200)

                val drawable = CircularProgressDrawable(binding.root.context)
                drawable.strokeWidth = 10f
                drawable.centerRadius = 50f
                drawable.setColorSchemeColors(color)
                drawable.start()

                Glide.with(itemView.context)
                    .load(item.headerImage)
                    .placeholder(drawable)
                    .into(placeImg)

                placeName.text = item.name
                placeCategory.text = item.category
                placeRating.text = item.rating.toString()
            }

        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListPlaceItem>() {
            override fun areItemsTheSame(oldItem: ListPlaceItem, newItem: ListPlaceItem): Boolean {
                Log.i("dataResponse", "DIFF_CALLBACK  areItemsTheSame : ${oldItem == newItem}")
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ListPlaceItem, newItem: ListPlaceItem): Boolean {
                Log.i("dataResponse", "DIFF_CALLBACK  areItemsTheSame : ${oldItem.id == newItem.id}")
                return oldItem.id == newItem.id
            }
        }
    }
}