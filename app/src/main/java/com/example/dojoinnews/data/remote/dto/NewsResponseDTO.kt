package com.example.dojoinnews.data.remote.dto

data class NewsResponseDTO(
    val copyright: String,
    val num_results: Int,
    val results: List<Result?>?,
    val status: String
)