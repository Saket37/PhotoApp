package com.example.photoapp.data

import com.example.photoapp.data.remote.UnsplashService
import javax.inject.Inject

class Repository @Inject constructor(private val unsplashService: UnsplashService) {
    suspend fun getRandomImages(count: Int) = unsplashService.getRandomImages(count)
}