package com.example.photoapp.hilt

import com.example.photoapp.data.remote.Constants
import com.example.photoapp.data.remote.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object UnsplashModule {
    @Provides
    fun getService(): UnsplashService {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UnsplashService::class.java)
    }
}
