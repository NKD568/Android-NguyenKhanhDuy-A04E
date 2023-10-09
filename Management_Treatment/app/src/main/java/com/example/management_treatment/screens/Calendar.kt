package com.example.management_treatment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode


@Composable
fun CalendarScreen() {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        val calendarState = rememberSelectableCalendarState(
            initialSelectionMode = SelectionMode.Multiple,
        )

        SelectableCalendar(
            calendarState = calendarState,
            modifier = Modifier
                .background(Color.Magenta),
        )
        val selectionState = calendarState.selectionState
        val selectedDays = selectionState.selection

        LazyColumn {
            selectedDays.forEach { selectedDay ->
                item {
                    Text(text = selectedDay.toString())
                }
            }
        }
    }
}


@Preview
@Composable
fun calendarPreview(){
    CalendarScreen()
}



//@Composable
//fun oldCalendar (){
//    Column (
//        modifier = Modifier
//            .background(Color.White)
//    ){
//        Row(
//            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Button(
//                onClick = { /* Handle previous month action */ },
//                modifier = Modifier.weight(1f),
//                content = { Text("Back") }
//            )
//
//            Text(
//                text = "Feb 2021",
//                fontSize = 20.sp,
//                modifier = Modifier.weight(1.5f),
//                textAlign = TextAlign.Center
//            )
//
//            Button(
//                onClick = { /* Handle next month action */ },
//                modifier = Modifier.weight(1f),
//                content = { Text("Forward") }
//            )
//        }
//
//        Row(
//            modifier = Modifier.padding(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Text(text = "SUN", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//            Text(text = "MON", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//            Text(text = "TUE", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//            Text(text = "WED", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//            Text(text = "THU", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//            Text(text = "FRI", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//            Text(text = "SAT", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.padding(10.dp))
//        }
//
//        // RecyclerView for the calendar
//        LazyColumn(
//            modifier = Modifier.fillMaxSize()
//        ) {
//        }
//    }
//}
