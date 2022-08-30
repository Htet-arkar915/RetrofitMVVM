package com.htetarkarlinn.retrofittesting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.htetarkarlinn.retrofittesting.R
import com.htetarkarlinn.retrofittesting.databinding.AdapterMovieBinding
import com.htetarkarlinn.retrofittesting.model.MovieModel

class MainAdapter(val mainActivity: Context,val movieList: MutableList<MovieModel>) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie,parent,false)
        return MainAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = AdapterMovieBinding.bind(holder.itemView)
        binding.name.text=movieList[position].name
        Glide.with(mainActivity).load(movieList[position].imageUrl).into(binding.imageview)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
