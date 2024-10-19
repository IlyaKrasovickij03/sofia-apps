package com.mk_sofia.feature_auth_screens.presentation.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mk_sofia.feature_auth_screens.R

@Composable
fun SofiaPrivateText(
    textId: Int,
) {
    Text(
        text = stringResource(id = textId),
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onBackground,
    )
}