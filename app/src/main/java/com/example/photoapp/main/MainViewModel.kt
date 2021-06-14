package com.example.photoapp.main

import android.app.Application
import androidx.lifecycle.*
import com.example.photoapp.data.Repository
import com.example.photoapp.data.remote.UnsplashService
import com.example.photoapp.data.remote.entity.RandomResult
import com.example.photoapp.data.remote.entity.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

const val IMAGE_COUNT = 10

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun loadRandomImages() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            val data = repository.getRandomImages(IMAGE_COUNT)
            emit(Resource.success(data))
        }catch (e: Exception) {
            emit(Resource.error(null, e.message ?: "Unknown error"))
        }
    }
}