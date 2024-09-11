package com.example.feature_message.ui.message_list.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_message.domain.convertToTheDay
import com.example.feature_message.domain.convertToTheMinute
import com.example.feature_message.ui.message_list.models.DialogModel
import java.util.Calendar
import java.util.Date

@Composable
internal fun MessageItem(dialogModel: DialogModel) {
    val lastMessage = dialogModel.messageList.last()
    Row(Modifier.padding(horizontal = Padding._12, vertical = Padding._12)) {
        Column {
            Text(
                text = dialogModel.userName,
                color = CustomColor.TextColor,
                style = FontStyle.medium_14
            )
            Spacer(modifier = Modifier.height(Padding._8))
            Text(
                text = lastMessage.message,
                color = CustomColor.TextColor,
                style = FontStyle.medium_12
            )
        }
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            Text(
                text = getDateFormat(lastMessage.date),
                color = CustomColor.Grey,
                style = FontStyle.medium_12
            )
        }
    }
}

private fun getDateFormat(date: Date): String {
    val calendar = Calendar.getInstance()
    calendar.time = date
    val rightNow = Calendar.getInstance()
    rightNow.time = Date()
    return when {
        (calendar.get(Calendar.DAY_OF_MONTH) == rightNow.get(Calendar.DAY_OF_MONTH)) -> date.convertToTheMinute()
        (calendar.get(Calendar.WEEK_OF_MONTH) == rightNow.get(Calendar.WEEK_OF_MONTH)) -> getDayOfTheWeek(
            calendar.get(Calendar.DAY_OF_WEEK)
        )

        else -> date.convertToTheDay()
    }
}

private fun getDayOfTheWeek(day: Int): String =
    when (day) {
        1 -> "пн"
        2 -> "вт"
        3 -> "ср"
        4 -> "чт"
        5 -> "пт"
        6 -> "сб"
        7 -> "вс"
        else -> ""
    }