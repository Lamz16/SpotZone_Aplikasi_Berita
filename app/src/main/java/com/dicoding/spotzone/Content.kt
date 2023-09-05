package com.dicoding.spotzone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
