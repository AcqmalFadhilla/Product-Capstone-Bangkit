package com.reev.telokkaapps.ui.favoriteplace.adapter

import android.content.Intent
import android.util.Log
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
import com.reev.telokkaapps.ui.dashboard.fragment.home.adapter.PlaceItemListAdapter
import com.reev.telokkaapps.ui.detail.DetailActivity
import com.reev.telokkaapps.utility.Constant

class FavoritePlaceListAdapter(private val dataList: List<TourismPlaceItem>) :
    RecyclerView.Adapter<FavoritePlaceListAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val binding = ItemPlaceBinding.bind(itemView)

            init {
                itemView.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val place = dataList[position]
                        place.let {
                            // Update. Aksi intent dipindahkan kesini
                            val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                                Log.i("dataResponse", "tempat yang diklik ${it.placeName}")
                                putExtra(Constant.DETAIL_PLACE, it.placeId)
                            }
                            itemView.context.startActivity(intent)
                        }
                    }
                }
            }

            fun bind(item: TourismPlaceItem) {
                binding.apply{

                    val color = ContextCompat.getColor(binding.root.context , R.color.blue_200)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritePlaceListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding = ItemPlaceBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: FavoritePlaceListAdapter.ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }
}