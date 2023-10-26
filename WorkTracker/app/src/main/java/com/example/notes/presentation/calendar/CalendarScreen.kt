package com.example.notes.presentation.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.notes.presentation.DayDao
import io.github.boguszpawlowski.composecalendar.CalendarState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import io.github.boguszpawlowski.composecalendar.SelectableCalendar


@Composable
fun CalendarScreen(
calendarState: CalendarState<DynamicSelectionState>
) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        val calendarState = calendarState
        SelectableCalendar(
            calendarState = calendarState,
            modifier = Modifier
                .background(Color.Magenta),
        )
        val selectionState = calendarState.selectionState
        val selectedDays = selectionState.selection


        LazyColumn() {
            selectedDays.forEach { selectedDay ->
                item {
                    Text(text = selectedDay.toString())
                }
            }
        }
    }
}