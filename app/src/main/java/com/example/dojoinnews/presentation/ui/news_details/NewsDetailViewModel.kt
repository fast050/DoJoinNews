package com.example.dojoinnews.presentation.ui.news_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.dojoinnews.domain.model.News
import dagger.assisted.AssistedInject
import javax.inject.Inject

class NewsDetailViewModel @AssistedInject constructor(
    state: SavedStateHandle
) : ViewModel() {

    val newsDetail = state.get<News>("News")
}