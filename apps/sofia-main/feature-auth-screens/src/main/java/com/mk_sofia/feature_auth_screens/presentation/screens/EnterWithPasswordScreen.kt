package com.mk_sofia.feature_auth_screens.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.widgets.SofiaTopAppBar
import com.mk_sofia.core.R
import com.mk_sofia.core.ui.theme.height12
import com.mk_sofia.core.ui.theme.height24
import com.mk_sofia.core.ui.theme.height28
import com.mk_sofia.core.ui.theme.height35
import com.mk_sofia.core.ui.theme.height8
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.widgets.SofiaCustomButton
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaTextField2

@Composable
fun EnterWithPasswordScreen() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = padding16)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ){
            SofiaTopAppBar(
                iconRes = R.drawable.ic_arrow_back,
                isNeedToShowIcon = true,
                screenTitleRes = null,
                onTopBarButtonClick = { }
            )
            Spacer(modifier = Modifier.height(height24))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height35),
                text = stringResource(
                    id = com.mk_sofia.feature_auth_screens.R.string.enter_with_password
                ),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.surface,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(height12))
            EnterInAccount()
            Spacer(modifier = Modifier.height(height8))
            Text(
                modifier = Modifier
                    .height(height24)
                    .clickable { }
                    .align(Alignment.CenterHorizontally),
                text = stringResource(
                    id = com.mk_sofia.feature_auth_screens.R.string.change_data
                ),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Spacer(modifier = Modifier.height(height28))
            SofiaTextField2(
                value = "",
                placeHolderTextId = com.mk_sofia.feature_auth_screens.R.string.password_place_holder,
                onValueChange = {},
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(height24))
            SofiaCustomButton(textRes = com.mk_sofia.feature_auth_screens.R.string.enter)
            Spacer(modifier = Modifier.height(height24))
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {  },
                text = stringResource(id = com.mk_sofia.feature_auth_screens.R.string.forgot_password),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.surface,
            )
        }
    }
}

@Composable
fun EnterInAccount() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(height24),
            text = stringResource(
                id = com.mk_sofia.feature_auth_screens.R.string.enter_password_to_login
            ),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primaryContainer,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(height24),
            text = "index@mail.com",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primaryContainer,
            textAlign = TextAlign.Center,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun EnterWithPasswordScreenPreview() {
    SofiaMainTheme {
        EnterWithPasswordScreen()
    }
}