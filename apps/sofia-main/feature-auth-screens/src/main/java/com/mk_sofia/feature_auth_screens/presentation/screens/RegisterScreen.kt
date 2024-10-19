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
import com.mk_sofia.core.ui.theme.height12
import com.mk_sofia.core.ui.theme.height24
import com.mk_sofia.core.ui.theme.height32
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.theme.padding4
import com.mk_sofia.core.ui.widgets.SofiaCustomButton
import com.mk_sofia.core.ui.widgets.SofiaTopAppBar
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaPrivateText
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaTextField3

@Composable
fun RegisterScreen() {
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
                screenTitleRes = com.mk_sofia.feature_auth_screens.R.string.registry,
                onTopBarButtonClick = {},
            )
            Spacer(modifier = Modifier.height(height24))
            SofiaTextField3(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.name_place_holder,
                onValueChange = {},
                keyboardType = KeyboardType.Text,
                titleId = com.mk_sofia.feature_auth_screens.R.string.title_name
            )
            Spacer(modifier = Modifier.height(height32))
            SofiaTextField3(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.email_place_holder,
                onValueChange = {},
                keyboardType = KeyboardType.Email,
                titleId = com.mk_sofia.feature_auth_screens.R.string.title_email
            )
            Spacer(modifier = Modifier.height(height32))
            SofiaTextField3(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.phone_place_holder,
                onValueChange = {},
                keyboardType = KeyboardType.Phone,
                titleId = com.mk_sofia.feature_auth_screens.R.string.title_phone
            )
            Spacer(modifier = Modifier.height(height32))
            SofiaTextField3(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.birth_day_place_holder,
                onValueChange = {},
                keyboardType = KeyboardType.Number,
                titleId = com.mk_sofia.feature_auth_screens.R.string.title_birth_day_date
            )
            Spacer(modifier = Modifier.height(height32))
            SofiaCustomButton(stringId = com.mk_sofia.feature_auth_screens.R.string.next)
            Spacer(modifier = Modifier.height(height12))
            SofiaPrivateText(textId = com.mk_sofia.feature_auth_screens.R.string.terms_of_use_register)
        }
    }
}

@Preview
@Composable
private fun RegistryScreenPreview() {
    SofiaMainTheme {
        RegisterScreen()
    }
}