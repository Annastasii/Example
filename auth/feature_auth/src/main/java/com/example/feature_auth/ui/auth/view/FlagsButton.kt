package com.example.feature_auth.ui.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.R
import com.example.feature_auth.ui.auth.model.Flags


@Composable
internal fun FlagsButton(
    code: String,
    onChangeCode: (String) -> Unit,
    onChangeFlag: (Flags) -> Unit,
) {
    val expanded = rememberSaveable { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = Padding._16)
    ) {
        TextField(
            value = code,
            onValueChange = { onChangeCode(it) },
            textStyle = FontStyle.regular_14 + TextStyle(color = CustomColor.TextColor),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = CustomColor.InputTextColor,
                unfocusedContainerColor = CustomColor.InputTextColor,
                focusedTextColor = CustomColor.TextColor,
                unfocusedTextColor = CustomColor.TextColor
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier
                .width(Padding._58)
                .height(Padding._48)
                .clip(RoundedCornerShape(10.dp)),
        )
        Spacer(modifier = Modifier.height(Padding._8))
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = null,
            tint = CustomColor.Grey,
            modifier = Modifier.clickable { expanded.value = !expanded.value }
        )

    }
    FlagsMenu(
        expanded = expanded.value,
        onChangeCode = { onChangeCode(it) },
        onChangeFlag = { onChangeFlag(it) },
        onDismissRequest = { expanded.value = !expanded.value })
}

@Composable
private fun FlagsMenu(
    expanded: Boolean,
    onChangeCode: (String) -> Unit,
    onChangeFlag: (Flags) -> Unit,
    onDismissRequest: () -> Unit,
) {
    DropdownMenu(
        modifier = Modifier.background(CustomColor.SecondaryBgColor),
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        FlagItem(Flags.RUSSIA, { onChangeCode(it) }, { onChangeFlag(it) })
        FlagItem(Flags.ENGLAND, { onChangeCode(it) }, { onChangeFlag(it) })
        Spacer(modifier = Modifier.padding(Padding._8))
    }
}


@Composable
fun FlagItem(
    flags: Flags,
    onChangeCode: (String) -> Unit,
    onChangeFlag: (Flags) -> Unit,
) {
    Image(
        painter = painterResource(id = getDrawable(flags)),
        contentDescription = null,
        Modifier
            .clickable {
                onChangeCode(flags.code)
                onChangeFlag(flags)
            }
            .size(Padding._48)
            .padding(start = Padding._8, end = Padding._8, top = Padding._8)
    )
}

fun getDrawable(flag: Flags): Int =
    when (flag) {
        Flags.RUSSIA -> R.drawable.ic_russia
        Flags.ENGLAND -> R.drawable.ic_english
    }

