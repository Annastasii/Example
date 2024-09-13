package com.example.feature_profile.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.core_ui.R
import com.example.feature_profile.ui.models.ProfileModel

@Composable
fun MainInfoGroup(profile: ProfileModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .background(CustomColor.SecondaryBgColor, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .padding(top = Padding._38, bottom = Padding._16)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(Padding._58)
                .clip(CircleShape)
                .border(Padding._2, CustomColor.ActiveButtonColor, CircleShape)
                .border(Padding._4, CustomColor.PrimaryBgColor, CircleShape)
        )
        Spacer(modifier = Modifier.height(Padding._12))
        Text(
            text = profile.username,
            color = CustomColor.Grey,
            style = FontStyle.regular_14
        )
        Spacer(modifier = Modifier.height(Padding._8))
        Text(
            text = profile.name,
            color = CustomColor.TextColor,
            style = FontStyle.medium_16
        )
    }
}