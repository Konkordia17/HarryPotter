package com.example.harrypotter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Character::class], version = 1)
abstract class HPDataBase : RoomDatabase() {

    abstract fun characterDao(): CharactersDao

    companion object {
        @Volatile
        private var INSTANCE: HPDataBase? = null

        fun getInstance(context: Context): HPDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HPDataBase::class.java, "Harry_Potter.db"
            )
                .build()
    }
}
