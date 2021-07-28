package com.test.restaurantes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.test.restaurantes.R
import com.test.restaurantes.databinding.RestaurantItemBinding
import com.test.restaurantes.framework.database.RestaurantEntity

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<RestaurantEntity>(){
        override fun areItemsTheSame(oldItem: RestaurantEntity, newItem: RestaurantEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RestaurantEntity, newItem: RestaurantEntity): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = RestaurantItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NewsViewHolder(
        val binding:RestaurantItemBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(entity: RestaurantEntity){

            Glide.with(binding.imageView.context)
                .load(entity.imageUrl)
                .placeholder(
                    CircularProgressDrawable(binding.imageView.context).apply {
                        strokeWidth = 3f
                        centerRadius = 30f
                        start()
                    }
                )
                .into(binding.imageView)


            binding.restaurantName.text = entity.name
            binding.restaurantAddress.text = entity.address

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(entity)
                }
            }
        }
    }

    private var onItemClickListener :((RestaurantEntity)->Unit)?=null

    fun setOnItemClickListener(listener : (RestaurantEntity)->Unit){
        onItemClickListener = listener
    }


}



