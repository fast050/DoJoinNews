package com.example.dojoinnews.presentation.ui.new_list

import android.util.Log
import androidx.lifecycle.*
import com.example.dojoinnews.commen.util.Resources
import com.example.dojoinnews.domain.model.News
import com.example.dojoinnews.domain.use_cases.GetNewsListUseCase
import com.example.dojoinnews.domain.util.NewsPeriod
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(private val newsListUseCase: GetNewsListUseCase) : ViewModel() {

    private val _newsList: MutableLiveData<Resources<List<News>>> = MutableLiveData()
    val newsList: LiveData<Resources<List<News>>> = _newsList

    fun getNewsListUseCase(period: NewsPeriod)= viewModelScope.launch{

         newsListUseCase(period).collectLatest {
            _newsList.value=it
        }
    }
}