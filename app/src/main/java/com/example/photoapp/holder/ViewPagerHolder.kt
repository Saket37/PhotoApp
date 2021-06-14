package com.example.photoapp.holder

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.photoapp.R
import com.example.photoapp.data.remote.entity.RandomResult
import com.example.photoapp.gesture.GestureListener
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    private val progressBar: ProgressBar = itemView.findViewById(R.id.sliderProgressBar)
    private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

    @SuppressLint("ClickableViewAccessibility")
    fun setRandomImage(randomResult: RandomResult) {
        val detector =
            GestureDetector(itemView.context, GestureListener(itemView.context, randomResult.urls))

        Picasso.with(itemView.context)
            .load(randomResult.urls.regular)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                    nameTextView.text = randomResult.user.name
                }

                override fun onError() {
                    Toast.makeText(itemView.context, "could not show image", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        imageView.setOnTouchListener { _, event ->
            detector.onTouchEvent(event)
        }

    }
}