package com.example.notes.presentation.screens.notes.component

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notes.R
import com.example.notes.domain.model.Note
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


@Composable
fun NoteCard(
    note: Note,
    onItemClick: (Note) -> Unit,
) {
    OutlinedCard(
        border = CardDefaults.outlinedCardBorder().copy(0.dp),
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onItemClick(note)
            },

        ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = note.title?:"",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                style = MaterialTheme.typography.bodyMedium,
                text = note.description?:"",
                maxLines = 9,
                overflow = TextOverflow.Ellipsis
            )
            DateAndTimerPicker(
                reminderDateTime = null,
            )
        }

    }
}

@Composable
fun DateAndTimerPicker(
    reminderDateTime: Date?,
) {
    val interactionSource = remember { MutableInteractionSource() }

    val mContext = LocalContext.current
    var selectedYear: Int = 0
    var selectedMonth: Int = 0
    var selectedDay: Int = 0
    var selectedHour: Int = 0
    var selectedMin: Int = 0

    // Instance to display today date in both date and time picker
    val today = Calendar.getInstance()

    // Creating a TimePicker dialog
    val mTimePickerDialog = TimePickerDialog(
        mContext, { _, hour: Int, minute: Int ->
            selectedHour = hour
            selectedMin = minute
            val calendar = Calendar.getInstance()
            calendar.set(
                selectedYear, selectedMonth, selectedDay, selectedHour, selectedMin
            )

        }, today[Calendar.HOUR_OF_DAY], today[Calendar.MINUTE], false
    )

    // Creating a DatePicker dialog
    val mDatePickerDialog = DatePickerDialog(
        mContext, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            selectedYear = year
            selectedMonth = month
            selectedDay = dayOfMonth
            mTimePickerDialog.show()
        }, today[Calendar.YEAR], today[Calendar.MONTH], today[Calendar.DAY_OF_MONTH]
    )

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp)
        .clickable(
            interactionSource = interactionSource, indication = null
        ) {
            mDatePickerDialog.show()
        }) {
        Icon(
            imageVector = Icons.Default.CalendarMonth,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.outline,
        )
        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            style = MaterialTheme.typography.bodyMedium,
            text = if (dateToString(reminderDateTime).isNullOrEmpty()) stringResource(id = R.string.pick_date_time)
            else dateToString(reminderDateTime)!!,
            fontWeight = FontWeight.W300,
            fontSize = 18.sp
        )
    }
}

fun dateToString(date: Date?): String? {
    val pattern = "h:mm a, MMM dd yyyy";
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.ENGLISH);
    return date?.let { simpleDateFormat.format(it) }
}

fun stringToDate(str: String): Date? {
    val simpleDateFormat = SimpleDateFormat("h:mm a, MMM dd yyyy", Locale.ENGLISH)
    return simpleDateFormat.parse(str)
}