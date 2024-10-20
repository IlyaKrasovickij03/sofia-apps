package com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.captionBold
import com.mk_sofia.core.ui.theme.captionRegular
import com.mk_sofia.core.ui.theme.height227
import com.mk_sofia.core.ui.theme.height8
import com.mk_sofia.core.ui.theme.padding12
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.core.ui.theme.width169
import com.mk_sofia.feature_categories_screen.R
import com.mk_sofia.core.R as CoreR

@Composable
fun ProductCard(
    productTitle: String,
) {
    Card(
        modifier = Modifier
            .height(height227)
            .width(width169),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = RoundedCornerShape(5.dp),
    ) {

        ImageBlock(
            modifier = Modifier.weight(0.55f)
        )
        Spacer(modifier = Modifier.height(height8))
        DescriptionBlock(
            modifier = Modifier
                .padding(horizontal = padding8)
                .padding(bottom = padding12)
                .weight(0.45f),
            productTitle = productTitle,
        )
    }

}

@Composable
private fun ImageBlock(
    modifier: Modifier = Modifier,
) {
    var isChecked by remember { mutableStateOf(false) }

    val iconRes = if (isChecked) CoreR.drawable.ic_like_active_24
    else CoreR.drawable.ic_like_unactive_24

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.kitchen_test),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = {
                isChecked = !isChecked
            },
        ) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }

}

@Composable
private fun DescriptionBlock(
    productTitle: String,
    modifier: Modifier = Modifier,
    productPrice: String = "От 39000 Р",
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier,
            text = productTitle,
            style = MaterialTheme.typography.captionRegular,
            color = MaterialTheme.colorScheme.surface,
        )
        Text(
            modifier = Modifier,
            text = productPrice,
            style = MaterialTheme.typography.captionBold,
            color = MaterialTheme.colorScheme.surface,
        )
    }
}


@Preview
@Composable
private fun ProductCardPreview() {
    SofiaMainTheme {
        ProductCard("Кухня такая")
    }
}