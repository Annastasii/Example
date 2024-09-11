package com.example.feature_message.ui.chat.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_message.domain.Constants.ACTIVE_USER
import com.example.feature_message.domain.convertToTheMinute
import com.example.feature_message.ui.message_list.models.MessageModel

@Composable
internal fun MessageItem(messageModel: MessageModel) {
    Box(
        Modifier
            .padding(Padding._8)
            .fillMaxWidth(),
        contentAlignment = leftOrRight(ACTIVE_USER, messageModel.userId)
    ) {
        Column(
            Modifier
                .getPadding(ACTIVE_USER, messageModel.userId)
                .background(CustomColor.SecondaryBgColor, RoundedCornerShape(15.dp))

        ) {
            Column(Modifier.padding(Padding._8)) {
                Box(contentAlignment = Alignment.TopStart) {
                    Text(
                        text = messageModel.message,
                        color = CustomColor.TextColor,
                        style = FontStyle.regular_14,
                    )
                }
                Spacer(modifier = Modifier.height(Padding._1))
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = messageModel.date.convertToTheMinute(),
                        color = CustomColor.Grey,
                        style = FontStyle.regular_12,
                    )
                }
            }
        }

    }
}

fun leftOrRight(activeUserserId: Int, userId: Int): Alignment =
    if (userId == activeUserserId) Alignment.CenterEnd else Alignment.CenterStart

private fun Modifier.getPadding(activeUserserId: Int, userId: Int): Modifier =
    if (userId == activeUserserId) Modifier.padding(start = Padding._38) else Modifier.padding(end = Padding._38)