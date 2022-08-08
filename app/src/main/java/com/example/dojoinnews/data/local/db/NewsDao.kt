package com.example.dojoinnews.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.dojoinnews.data.local.entity.NewsEntity
import com.example.dojoinnews.domain.model.News
import com.example.dojoinnews.domain.util.NewsPeriod
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = IGNORE)
    suspend fun insertNews(news:List<NewsEntity>)

    @Query("delete from news_entity")
    suspend fun clearCache()

    @Query("select * from news_entity")
    suspend fun getCacheNews() : List<NewsEntity>

}

class s {}