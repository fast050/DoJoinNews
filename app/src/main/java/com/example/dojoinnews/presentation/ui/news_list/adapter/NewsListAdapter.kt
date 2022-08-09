package com.example.dojoinnews.presentation.ui.news_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dojoinnews.databinding.NewsListItemBinding
import com.example.dojoinnews.domain.model.News

class NewsListAdapter(val listener : (News)->(Unit)) : ListAdapter<News, NewsListViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(getItem(position),listener)


    }


    object Diff : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
            oldItem == newItem

    }
}
