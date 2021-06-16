package com.example.photoapp.data.remote

import com.example.photoapp.BuildConfig

object Constants {
    const val API_BASE = "https://api.unsplash.com/"
    const val API_VERSION = "v1"
    // TODO - In a production app hide this key in native lib
    const val ACCESS_KEY = BuildConfig.ApiKey
}