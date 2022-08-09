package com.example.dojoinnews.presentation.ui.news_list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.dojoinnews.databinding.NewsListItemBinding
import com.example.dojoinnews.domain.model.News

class NewsListViewHolder(private val binding: NewsListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News,listener:(News)->(Unit)) {
        binding.news = news

        binding.root.setOnClickListener {
            listener(news)
        }
    }


}