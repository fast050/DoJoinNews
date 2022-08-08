package com.example.dojoinnews.data.dto

data class NewsResponseDTO(
    val copyright: String,
    val num_results: Int,
    val results: List<NewsDTO>,
    val status: String
)