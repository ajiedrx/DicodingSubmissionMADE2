package com.example.dicodingsubmission2made.core.injection.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance  = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "appdb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getDao(): FavoriteFilmDao
}