package com.example.dojoinnews.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_entity")
data class NewsEntity(
    @PrimaryKey
    val id :Long,
    val title: String,
    val image: String,
    val newsBy: String,
    val publishedDate: String,
    val url:String,
    val subject:String,
    val source:String
)