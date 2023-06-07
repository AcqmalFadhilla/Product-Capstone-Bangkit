package com.reev.telokkaapps.ui.dashboard.fragment.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.relation.PlaceAndTourismCategory
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.ItemSearchingListBinding

class SearchItemListAdapter(private val dataList: List<PlaceAndTourismCategory>, private val listener: OnPlaceItemClickListener) :
    RecyclerView.Adapter<SearchItemListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemSearchingListBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val place = dataList[position]
                    listener.onPlaceItemClick(place)
                }
            }
        }

        fun bind(item: PlaceAndTourismCategory) {
            binding.apply{

                val color = ContextCompat.getColor(binding.root.context , R.color.blue_200)

                val drawable = CircularProgressDrawable(binding.root.context)
                drawable.strokeWidth = 10f
                drawable.centerRadius = 50f
                drawable.setColorSchemeColors(color)
                drawable.start()

                Glide.with(itemView.context)
                    .load(item.tourismPlace.placePhotoUrl)
                    .placeholder(drawable)
                    .into(placeImg)

                placeName.text = item.tourismPlace.placeName
                placeCategory.text = item.category?.categoryName
                placeRating.text = item.tourismPlace.placeRating.toString()
            }
        }
    }

    interface  OnPlaceItemClickListener {
        fun onPlaceItemClick(place: PlaceAndTourismCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding = ItemSearchingListBinding.inflate(inflater, parent, false)
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