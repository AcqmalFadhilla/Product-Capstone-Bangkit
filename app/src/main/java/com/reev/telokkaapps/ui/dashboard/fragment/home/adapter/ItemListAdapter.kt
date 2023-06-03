package com.reev.telokkaapps.ui.dashboard.fragment.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.ItemPlaceBinding

class ItemListAdapter(private val dataList: List<Place>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemPlaceBinding.bind(itemView)

        fun bind(item: Place) {
            Glide.with(itemView.context)
                .load(item.photoUrl)
                .apply(RequestOptions().transform(RoundedCorners(8)))
                .error(R.drawable.img_place_bg)
                .into(binding.placeImg)

            binding.placeName.text = item.name
            binding.placeCategory.text = item.category
            binding.placeRating.text = item.rating
        }
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