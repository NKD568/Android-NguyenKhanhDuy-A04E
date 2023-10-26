package com.example.notes.presentation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "days_table")
class CalendarDays(
    @PrimaryKey @ColumnInfo(name = "day") val days: Date)