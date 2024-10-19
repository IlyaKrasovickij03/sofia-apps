package com.mk_sofia.feature_auth_screens.presentation.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mk_sofia.core.ui.theme.Black
import com.mk_sofia.core.ui.theme.White
import com.mk_sofia.core.ui.theme.cornerRadius8

@Composable
fun SofiaTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
//    val tabTextColor: Color by animateColorAsState(
//        targetValue = if (isSelected) {
//            MaterialTheme.colorScheme.surfaceVariant
//        } else {
//            MaterialTheme.colorScheme.surface
//        },
//        animationSpec = tween(easing = LinearEasing),
//    )

    val textSize = remember { Animatable(initialValue = 12f) }

    LaunchedEffect(isSelected) {
        if (isSelected) {
            textSize.animateTo(
                targetValue = 14f,
                animationSpec = tween(durationMillis = 200)
            )
        } else {
            textSize.animateTo(
                targetValue = 13f,
                animationSpec = tween(durationMillis = 200)
            )
        }

    }

    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(cornerRadius8))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontSize = textSize.value.sp,
        color = MaterialTheme.colorScheme.surface,
        textAlign = TextAlign.Center,
    )
}