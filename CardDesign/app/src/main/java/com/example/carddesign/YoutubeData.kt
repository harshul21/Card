package com.example.carddesign

import androidx.annotation.DrawableRes

data class YoutubeData(
    @DrawableRes val thumbnail: Int,
    val videTitle : String,
    val videoChannel : String,
)
