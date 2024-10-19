package com.mk_sofia.feature_auth_screens.presentation.widgets

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import com.mk_sofia.core.ui.theme.cornerRadius8
import com.mk_sofia.core.ui.theme.height32
import com.mk_sofia.core.ui.theme.height35

@Composable
fun SofiaCustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp,
    onClick: (index: Int) -> Unit,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = FastOutSlowInEasing, durationMillis = 250),
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius8))
            .background(MaterialTheme.colorScheme.background)
            .height(intrinsicSize = IntrinsicSize.Min)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.height(height35),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            SofiaTabIndicator(
                indicatorWidth = tabWidth,
                indicatorOffset = indicatorOffset,
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(height35)
                .clip(RoundedCornerShape(cornerRadius8))
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                SofiaTabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}