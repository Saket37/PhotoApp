package com.example.photoapp.data

import com.example.photoapp.data.remote.UnsplashService

class Repository(private val unsplashService: UnsplashService) {
    suspend fun getRandomImages(count: Int) = unsplashService.getRandomImages(count)
}