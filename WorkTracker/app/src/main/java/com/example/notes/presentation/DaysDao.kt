package com.example.notes.presentation

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DayDao {

    @Query("SELECT * FROM days_table")
    fun getAllSelectedDays(): Flow<List<CalendarDays>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(days: CalendarDays)

    @Query("DELETE FROM days_table")
    suspend fun deleteAll()
}