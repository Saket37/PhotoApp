package com.example.photoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoapp.R
import com.example.photoapp.data.remote.entity.RandomResult
import com.example.photoapp.holder.ViewPagerHolder
import javax.inject.Inject

class ViewPagerAdapter @Inject constructor() : RecyclerView.Adapter<ViewPagerHolder>() {
    var randomImages: List<RandomResult> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder =
        ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.image_slider,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        with(randomImages[position]) {
            holder.setRandomImage(this)
        }
    }

    override fun getItemCount(): Int = randomImages.size
}