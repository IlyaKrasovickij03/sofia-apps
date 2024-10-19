package com.mk_sofia.feature_auth_screens.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.R
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.height24
import com.mk_sofia.core.ui.theme.height32
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.theme.padding4
import com.mk_sofia.core.ui.widgets.SofiaCustomButton
import com.mk_sofia.core.ui.widgets.SofiaTopAppBar
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaTextField3

@Composable
fun CreatePasswordScreen() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = padding16)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            SofiaTopAppBar(
                iconRes = R.drawable.ic_arrow_back,
                isNeedToShowIcon = true,
                isNeedToShowText = true,
                screenTitleRes = com.mk_sofia.feature_auth_screens.R.string.creating_password,
                onTopBarButtonClick = {},
            )
            Spacer(modifier = Modifier.height(height24))
            SofiaTextField3(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.title_password,
                onValueChange = {},
                keyboardType = KeyboardType.Password,
                titleId = com.mk_sofia.feature_auth_screens.R.string.title_password
            )
            Spacer(modifier = Modifier.height(height32))
            SofiaTextField3(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.title_repeat_password,
                onValueChange = {},
                keyboardType = KeyboardType.Password,
                titleId = com.mk_sofia.feature_auth_screens.R.string.title_repeat_password
            )
            Spacer(modifier = Modifier.height(height32))
            SofiaCustomButton(stringId = com.mk_sofia.feature_auth_screens.R.string.next)
        }
    }
}

@Preview
@Composable
private fun CreatePasswordScreenPreview() {
    SofiaMainTheme {
        CreatePasswordScreen()
    }
}