package com.example.photoapp.data.remote.entity

import com.squareup.moshi.Json

data class URL(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    var thumb: String
)