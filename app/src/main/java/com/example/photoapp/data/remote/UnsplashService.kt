package com.example.photoapp.data.remote

import android.content.Context
import com.example.photoapp.data.remote.entity.RandomResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface UnsplashService {

    companion object Factory {
        fun getService(): UnsplashService {
            return Retrofit.Builder()
                .baseUrl(Constants.API_BASE)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(UnsplashService::class.java)
        }
    }

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