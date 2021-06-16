package com.example.photoapp.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.photoapp.data.Repository
import com.example.photoapp.data.remote.entity.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

const val IMAGE_COUNT = 10

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun loadRandomImages() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            val data = repository.getRandomImages(IMAGE_COUNT)
            emit(Resource.success(data))
        } catch (e: Exception) {
            emit(Resource.error(null, e.message ?: "Unknown error"))
        }
    }
}