package com.example.feature_auth.ui.auth.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.feature_auth.R

@Composable
internal fun PhoneField(
    phone: String,
    onChangePhoneNumber: (phoneNumber: String) -> Unit,
) {
    val mask = "(000)000-00-00"
    val maskNumber = '0'
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(
                start = Padding._8,
                top = Padding._16,
                bottom = Padding._16,
                end = Padding._16
            )
        ) {
            TextField(
                value = phone,
                onValueChange = { newText ->
                    onChangePhoneNumber(
                        newText.filterToDigits(
                            mask,
                            maskNumber
                        )
                    )
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
                    if (phone.isNotBlank()) {
                        Icon(
                            painter = painterResource(id = R.drawable.union),
                            contentDescription = null,
                            tint = CustomColor.GreyLight,
                            modifier = Modifier.clickable { onChangePhoneNumber("") }
                        )
                    }
                },
                placeholder = {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = stringResource(id = R.string.phone_number),
                            style = FontStyle.regular_14,
                            color = CustomColor.Grey
                        )
                    }
                },
                visualTransformation = PhoneVisualTransformation(mask, maskNumber)
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

class PhoneVisualTransformation(private val mask: String, private val maskNumber: Char) :
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

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

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