package com.mk_sofia.feature_profile_screen.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.cornerRadius20
import com.mk_sofia.core.ui.theme.height215
import com.mk_sofia.core.ui.theme.height24
import com.mk_sofia.core.ui.theme.height34
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.feature_categories_screen.R

@Composable
fun ProfileMainCard(
    userName: String,
    ) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(cornerRadius20))
            .height(height215)
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surfaceVariant),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding16)
            .padding(top = padding16),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.surface,
            )
        }
        Spacer(modifier = Modifier.height(height24))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding16),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.my_coupons),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primaryContainer,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileMainCardPreview() {
    SofiaMainTheme {
        ProfileMainCard(userName = "Иван")
    }
}