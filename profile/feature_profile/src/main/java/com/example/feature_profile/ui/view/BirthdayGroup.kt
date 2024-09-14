package com.example.feature_profile.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_message.domain.stringToDate
import com.example.feature_profile.R
import java.util.Calendar

@Composable
fun BirthdayGroup(date: String, onChangeDate: (String) -> Unit) {
    val mask = "0000-00-00"
    val maskNumber = '0'
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.birthday),
                color = CustomColor.Grey,
                style = FontStyle.regular_12
            )
            Spacer(modifier = Modifier.height(Padding._4))
            TextField(
                value = date,
                onValueChange = {
                    onChangeDate(it.filterToDigits(mask, maskNumber))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                modifier = Modifier
                    .background(CustomColor.SecondaryBgColor)
                    .clip(RoundedCornerShape(10.dp))
                    .height(Padding._48)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = CustomColor.InputTextColor,
                    unfocusedContainerColor = CustomColor.InputTextColor,
                    focusedTextColor = CustomColor.TextColor,
                    unfocusedTextColor = CustomColor.TextColor
                ),
                trailingIcon = {
                    if (date.isNotBlank()) {
                        Icon(
                            painter = painterResource(id = R.drawable.union),
                            contentDescription = null,
                            tint = CustomColor.GreyLight,
                            modifier = Modifier.clickable { onChangeDate("") }
                        )
                    }
                },
                placeholder = {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = stringResource(id = R.string.birthday),
                            style = FontStyle.regular_14,
                            color = CustomColor.Grey
                        )
                    }
                },
//                visualTransformation = PhoneVisualTransformation(mask, maskNumber)
            )
            Spacer(modifier = Modifier.height(Padding._12))
            Text(
                text = stringResource(id = R.string.zodiac),
                color = CustomColor.Grey,
                style = FontStyle.regular_12
            )
            Spacer(modifier = Modifier.height(Padding._4))
            Text(
                text = getZodiac(date),
                color = CustomColor.TextColor,
                style = FontStyle.regular_16
            )
        }
    }
}

private fun String.filterToDigits(mask: String, maskNumber: Char): String {
    var result = ""
    var maskIndex = 0
    forEach { char ->
        while (maskIndex < mask.length && mask[maskIndex] != maskNumber) {
            maskIndex++
        }
        if (maskIndex < mask.length && char.isDigit()) {
            result += char
            maskIndex++
        }
    }
    return result
}

class DateVisualTransformation(private val mask: String, private val maskNumber: Char) :
    VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, DateOffsetMapper(mask, maskNumber))
    }
}

private class DateOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}

fun getZodiac(date: String): String {
    val d = date.substring(5, 10).stringToDate()
    val calendar = Calendar.getInstance()
    calendar.time = d
    return when {
        (calendar.get(Calendar.MONTH) == 11 && calendar.get(Calendar.DAY_OF_MONTH) >= 22)
                || (calendar.get(Calendar.MONTH) == 0 && calendar.get(Calendar.DAY_OF_MONTH) <= 19) -> "Козерог"

        (calendar.get(Calendar.MONTH) == 0 && calendar.get(Calendar.DAY_OF_MONTH) >= 20)
                || (calendar.get(Calendar.MONTH) == 1 && calendar.get(Calendar.DAY_OF_MONTH) <= 18) -> "Водолей"

        (calendar.get(Calendar.MONTH) == 1 && calendar.get(Calendar.DAY_OF_MONTH) >= 19)
                || (calendar.get(Calendar.MONTH) == 2 && calendar.get(Calendar.DAY_OF_MONTH) <= 20) -> "Рыбы"

        (calendar.get(Calendar.MONTH) == 2 && calendar.get(Calendar.DAY_OF_MONTH) >= 21)
                || (calendar.get(Calendar.MONTH) == 3 && calendar.get(Calendar.DAY_OF_MONTH) <= 19) -> "Овен"

        (calendar.get(Calendar.MONTH) == 3 && calendar.get(Calendar.DAY_OF_MONTH) >= 20)
                || (calendar.get(Calendar.MONTH) == 4 && calendar.get(Calendar.DAY_OF_MONTH) <= 20) -> "Телец"

        (calendar.get(Calendar.MONTH) == 4 && calendar.get(Calendar.DAY_OF_MONTH) >= 21)
                || (calendar.get(Calendar.MONTH) == 5 && calendar.get(Calendar.DAY_OF_MONTH) <= 20) -> "Близнецы"

        (calendar.get(Calendar.MONTH) == 5 && calendar.get(Calendar.DAY_OF_MONTH) >= 21)
                || (calendar.get(Calendar.MONTH) == 6 && calendar.get(Calendar.DAY_OF_MONTH) <= 2) -> "Рак"

        (calendar.get(Calendar.MONTH) == 6 && calendar.get(Calendar.DAY_OF_MONTH) >= 23)
                || (calendar.get(Calendar.MONTH) == 7 && calendar.get(Calendar.DAY_OF_MONTH) <= 22) -> "Лев"

        (calendar.get(Calendar.MONTH) == 7 && calendar.get(Calendar.DAY_OF_MONTH) >= 23)
                || (calendar.get(Calendar.MONTH) == 8 && calendar.get(Calendar.DAY_OF_MONTH) <= 22) -> "Дева"

        (calendar.get(Calendar.MONTH) == 8 && calendar.get(Calendar.DAY_OF_MONTH) >= 23)
                || (calendar.get(Calendar.MONTH) == 9 && calendar.get(Calendar.DAY_OF_MONTH) <= 22) -> "Весы"

        (calendar.get(Calendar.MONTH) == 9 && calendar.get(Calendar.DAY_OF_MONTH) >= 23)
                || (calendar.get(Calendar.MONTH) == 10 && calendar.get(Calendar.DAY_OF_MONTH) <= 21) -> "Скорпион"

        (calendar.get(Calendar.MONTH) == 10 && calendar.get(Calendar.DAY_OF_MONTH) >= 22)
                || (calendar.get(Calendar.MONTH) == 11 && calendar.get(Calendar.DAY_OF_MONTH) <= 21) -> "Стрелец"

        else -> ""
    }
}