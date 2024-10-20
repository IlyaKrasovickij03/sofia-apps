package com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.bodyRegular
import com.mk_sofia.core.ui.theme.darkCard
import com.mk_sofia.core.ui.theme.height8
import com.mk_sofia.core.ui.theme.iconDark
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.feature_categories_screen.R
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel

@Composable
fun CategoryWidget(
    categoryName: String,
    productList: List<ProductModel>
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(bottom = 52.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = padding16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CategoryItem(modifier = Modifier,
                categoryName = categoryName
            )
            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_next_24),
                    tint = MaterialTheme.colorScheme.iconDark,
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(productList) { productModel ->
                ProductCard(
                    productTitle = productModel.name
                )
            }
        }
    }
}

@Composable
private fun CategoryItem(
    categoryName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .height(28.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(MaterialTheme.colorScheme.darkCard),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 10.dp),
            text = categoryName,
            style = MaterialTheme.typography.bodyRegular,
            color = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryWidgetPreview() {
    SofiaMainTheme {
        CategoryWidget(
            categoryName = "Шкафы",
            productList = listOf(
                ProductModel(
                    id = 1,
                    name = "Шкаф 1",
                    categoryId = 1,
                ),
                ProductModel(
                    id = 2,
                    name = "Шкаф 2",
                    categoryId = 2,
                ),
                ProductModel(
                    id = 3,
                    name = "Шкаф 3",
                    categoryId = 3,
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryItemPreview() {
    SofiaMainTheme {
        CategoryItem(
            categoryName = "Шкафы"
        )
    }
}