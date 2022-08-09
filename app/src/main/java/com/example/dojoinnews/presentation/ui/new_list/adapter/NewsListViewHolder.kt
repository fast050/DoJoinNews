package com.example.dojoinnews.presentation.ui.new_list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.dojoinnews.databinding.NewsListItemBinding
import com.example.dojoinnews.domain.model.News

class NewsListViewHolder(private val binding: NewsListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.news = news
    }


}