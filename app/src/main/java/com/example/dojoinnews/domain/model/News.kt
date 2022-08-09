package com.example.dojoinnews.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val image: String,
    val newsBy: String,
    val publishedDate: String,
    val url:String,
    val subject:String,
    val source:String
): Parcelable
