package com.mk_sofia.feature_auth_screens.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.cornerRadius5
import com.mk_sofia.core.ui.theme.height100
import com.mk_sofia.core.ui.theme.height11
import com.mk_sofia.core.ui.theme.height25
import com.mk_sofia.core.ui.theme.height40
import com.mk_sofia.core.ui.theme.height44
import com.mk_sofia.core.ui.theme.height68
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.widgets.SofiaCustomButton
import com.mk_sofia.feature_auth_screens.R
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaCustomTab
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaPrivateText
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaTextField
import com.mk_sofia.feature_auth_screens.presentation.widgets.SofiaTextField2

@Composable
fun EnterRegisterScreen() {
    val (selected, setSelected) = remember {
        mutableIntStateOf(0)
    }

    val neededConfigurationWidthDp = LocalConfiguration.current.screenWidthDp/2-16
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
            Spacer(modifier = Modifier.height(height100))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height68),
                text = stringResource(id = R.string.enter_or_create_account),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.surface,
                textAlign = TextAlign.Center,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(height25))
            SofiaCustomTab(
                selectedItemIndex = selected,
                items = listOf("Телефон", "Почта"),
                onClick = setSelected,
                tabWidth = neededConfigurationWidthDp.dp
            )
            Spacer(modifier = Modifier.height(height40))
            PhoneOrEmailTextField(selectedItemId = selected)
            Spacer(modifier = Modifier.height(height25))
            SofiaCustomButton(
                stringId = R.string.get_code,
                onClick = {
                    val database = FirebaseDatabase.getInstance().getReference("Sofia")
                    database.child("Kategory").setValue(Kategory(1, "Kitchen"))
                }
            )
            Spacer(modifier = Modifier.height(height11))
            SofiaPrivateText(textId = R.string.terms_of_use)
        }
    }
}

data class Kategory(
    val id: Int,
    val name: String,
)

@Composable
fun PhoneOrEmailTextField(selectedItemId: Int) {
    if (selectedItemId == 0) {
        SofiaTextField2(
            value = "",
            keyboardType = KeyboardType.Phone,
            onValueChange = {},
            placeHolderTextId = R.string.phone_place_holder,
        )
    } else {
        SofiaTextField2(
            value = "",
            keyboardType = KeyboardType.Email,
            onValueChange = {},
            placeHolderTextId = R.string.email_place_holder,
            placeHolderTextStyle = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EnterRegisterScreenPreview() {
    SofiaMainTheme {
        EnterRegisterScreen()
    }
}