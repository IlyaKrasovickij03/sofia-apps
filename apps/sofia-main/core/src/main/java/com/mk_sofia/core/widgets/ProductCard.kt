package com.mk_sofia.core.widgets

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.height227
import com.mk_sofia.core.ui.theme.width169

@Composable
fun ProductCard() {
    Card(modifier = Modifier
        .height(height227)
        .width(width169)
    ) {

    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    SofiaMainTheme {
        ProductCard()
    }
}