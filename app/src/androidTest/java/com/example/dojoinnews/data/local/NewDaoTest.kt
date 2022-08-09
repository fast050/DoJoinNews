package com.example.dojoinnews.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dojoinnews.data.local.db.NewsDao
import com.example.dojoinnews.data.local.db.NewsDatabase
import com.example.dojoinnews.data.local.entity.NewsEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewDaoTest {

    lateinit var newsDatabase: NewsDatabase
    lateinit var newsDao: NewsDao

    @Before
    fun setUp() {
        newsDatabase =
            Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                NewsDatabase::class.java
            ).allowMainThreadQueries().build()

        newsDao = newsDatabase.newsDao()
    }

    @After
    fun tearDown() {
        newsDatabase.close()
    }

    @Test
    fun insertNews() = runBlocking {
        val listOfNews = UtilData.listOfNewsEntity
        newsDao.insertNews(listOfNews)

        val listFromDatabase = newsDao.getCacheNews()

        assertEquals(listFromDatabase, listOfNews)
    }

    @Test
    fun clearNews() = runBlocking {
        val listOfNews = UtilData.listOfNewsEntity
        newsDao.insertNews(listOfNews)
        newsDao.clearCache()

        assertTrue(newsDao.getCacheNews().isEmpty())
    }
}