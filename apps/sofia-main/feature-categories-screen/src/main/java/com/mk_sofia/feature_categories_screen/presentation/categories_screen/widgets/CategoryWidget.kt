package com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.height8
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel

@Composable
fun CategoryWidget(
    categoryName: String,
    productList: List<ProductModel>
) {
    Column(modifier = Modifier) {
        Text(modifier = Modifier,
            text = categoryName
        )
        Spacer(modifier = Modifier.height(height8))
        LazyRow {
            items(productList) { productModel ->
                ProductCard(
                    productTitle = productModel.name
                )
            }
        }
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