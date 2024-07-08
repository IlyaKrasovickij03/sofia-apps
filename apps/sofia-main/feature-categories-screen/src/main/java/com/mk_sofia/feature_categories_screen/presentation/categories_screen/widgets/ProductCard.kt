package com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.height102
import com.mk_sofia.core.ui.theme.height227
import com.mk_sofia.core.ui.theme.height8
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.core.ui.theme.width153
import com.mk_sofia.core.ui.theme.width169
import com.mk_sofia.feature_sofia_cached_image.SofiaCachedImage

@Composable
fun ProductCard(
    imageUrl: String,
    productTitle: String,
) {
    Card(modifier = Modifier
        .height(height227)
        .width(width169)
    ) {
        SofiaCachedImage(imageUrl = imageUrl,
            success = { imageBitmap ->
                Image(
                    modifier = Modifier
                        .height(height102)
                        .width(width153)
                        .padding(horizontal = padding8)
                        .padding(top = padding8),
                    bitmap = imageBitmap,
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(height8))
        Text(modifier = Modifier
            .padding(horizontal = padding8),
            text = productTitle)
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    SofiaMainTheme {
        ProductCard("", "")
    }
}