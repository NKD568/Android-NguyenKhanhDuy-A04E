package com.example.notes.presentation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(CalendarDays::class), version = 1, exportSchema = false)
public abstract class DayRoomDatabase : RoomDatabase() {

    abstract fun dayDao(): DayDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DayRoomDatabase? = null

        fun getDatabase(context: Context): DayRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DayRoomDatabase::class.java,
                    "day_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}