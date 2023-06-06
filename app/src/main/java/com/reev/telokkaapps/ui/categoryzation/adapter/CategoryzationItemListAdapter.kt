package com.reev.telokkaapps.ui.categoryzation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reev.telokkaapps.data.source.local.dummy.dummycategory.Category
import com.reev.telokkaapps.databinding.ItemCategoryzationBinding

class CategoryzationItemListAdapter(private val categoryList: List<Category>, private val listener: OnCategoryItemClickListener) :
    RecyclerView.Adapter<CategoryzationItemListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCategoryzationBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val category = categoryList[position]
                    listener.onCategoryClick(category)
                }
            }
        }
        fun bind(item : Category) {
            binding.imageCategory.setImageResource(item.image)
            binding.textCategoryName.text = item.name
        }
    }

    interface OnCategoryItemClickListener {
        fun onCategoryClick(category: Category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding = ItemCategoryzationBinding.inflate(inflater, parent, false)
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