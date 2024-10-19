package com.mk_sofia.core.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.R
import com.mk_sofia.core.ui.theme.cornerRadius5
import com.mk_sofia.core.ui.theme.height44

@Composable
fun SofiaCustomButton(
    stringId: Int,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(height44),
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius5),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .align(Alignment.CenterVertically),
            text = stringResource(id = stringId),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

