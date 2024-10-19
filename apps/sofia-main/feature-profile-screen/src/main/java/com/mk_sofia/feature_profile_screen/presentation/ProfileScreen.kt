package com.mk_sofia.feature_profile_screen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.height12
import com.mk_sofia.core.ui.theme.height64
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.feature_categories_screen.R
import com.mk_sofia.feature_profile_screen.presentation.widgets.ProfileMainCard

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = padding16)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Spacer(modifier = Modifier.height(height12))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(height64)
                .padding(horizontal = padding16),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.profile),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.surface
                )
                Icon(
                    painter = painterResource(id = com.mk_sofia.core.R.drawable.ic_notifications),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.height(height12))
            ProfileMainCard(userName = "Олег")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    SofiaMainTheme {
        ProfileScreen()
    }
}