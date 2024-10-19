package com.mk_sofia.feature_auth_screens.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mk_sofia.core.ui.theme.cornerRadius7
import com.mk_sofia.core.ui.theme.elevation8

@Composable
fun SofiaTabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .height(24.dp)
            .fillMaxWidth()
            .padding(start = 4.dp, end = indicatorWidth+4.dp)
            .offset(
                x = indicatorOffset,
            )
            .shadow(elevation = elevation8, shape = RoundedCornerShape(cornerRadius7))
            .background(
                color = indicatorColor,
            )
            .clip(
                shape = RoundedCornerShape(cornerRadius7),
            )
    )
}