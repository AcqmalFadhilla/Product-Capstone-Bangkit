package com.reev.telokkaapps.ui.dashboard.fragment.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.databinding.ItemCategoryBinding

class CategoryItemListAdapter(private val categoryList: List<TourismCategory>) :
    RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCategoryBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val category = categoryList[position]
                    // Pidahkan Aksi onClick disini
                    Toast.makeText(itemView.context, "Anda klik ${category.categoryName}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        fun bind(item : TourismCategory) {
            binding.imageCategory.setImageResource(item.imageResource)
            binding.textCategoryName.text = item.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.bind(currentItem)
    }
}