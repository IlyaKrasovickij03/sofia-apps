package com.mk_sofia.core.ui.widgets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.R
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.height64
import com.mk_sofia.core.ui.theme.padding12
import com.mk_sofia.core.ui.theme.width12

@Composable
fun SofiaTopAppBar(
    @DrawableRes iconRes: Int,
    @StringRes screenTitleRes: Int?,
    isNeedToShowIcon: Boolean,
    isNeedToShowText: Boolean,
    onTopBarButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height64)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        if (isNeedToShowIcon) {
            IconButton(
                onClick = onTopBarButtonClick,
                modifier = Modifier
                    .padding(padding12)
            ) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
        }
        Spacer(modifier = Modifier.width(width12))
        if (isNeedToShowText && screenTitleRes != null) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = stringResource(id = screenTitleRes),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SofiaTopAppBarPreview() {
    SofiaMainTheme {
        SofiaTopAppBar(
            iconRes = R.drawable.ic_arrow_back,
            isNeedToShowIcon = true,
            isNeedToShowText = true,
            screenTitleRes = null,
            onTopBarButtonClick = {}
        )
    }
}