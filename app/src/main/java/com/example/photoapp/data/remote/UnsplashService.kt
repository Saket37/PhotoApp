package com.example.photoapp.data.remote

import com.example.photoapp.data.remote.entity.RandomResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashService {


    @GET("/photos/random")
    @Headers(
        "Accept-Version: ${Constants.API_VERSION}",
        "Authorization: Client-ID ${Constants.ACCESS_KEY}"
    )
    suspend fun getRandomImages(
        @Query("count") count: Int,
        @Query("orientation") orientation: String = "portrait"
    ): List<RandomResult>
}