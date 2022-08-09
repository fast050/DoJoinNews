package com.example.dojoinnews.data.local.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.dojoinnews.data.local.entity.NewsEntity


@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase() : RoomDatabase() {
   abstract fun newsDao():NewsDao

   companion object{
       const val DATABASE_NAME ="news.db"
   }
}