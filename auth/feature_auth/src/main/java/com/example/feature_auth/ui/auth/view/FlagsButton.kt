package com.example.feature_auth.ui.auth.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.feature_auth.R
import com.example.feature_auth.ui.auth.model.Flags

@Composable
private fun FlagsButton(flag: Flags) {
    Box(
        modifier = Modifier
            .background(CustomColor.SecondaryBgColor, RoundedCornerShape(10.dp))
    ) {
        Icon(painter = painterResource(getDrawable(flag)), contentDescription = null)
//        FlagsMenu()
    }
}

@Composable
private fun FlagsMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
) {
    DropdownMenu(
        modifier = Modifier.background(CustomColor.SecondaryBgColor),
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {

    }
}

fun getDrawable(flag: Flags): Int =
    when (flag) {
        Flags.RUSSIA -> R.drawable.ic_russia
        Flags.ENGLAND -> R.drawable.ic_english
    }

