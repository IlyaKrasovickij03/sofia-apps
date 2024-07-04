package com.mk_sofia.sofiamain.presentation.categories_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.sofiamain.presentation.categories_screen.widgets.CategoryWidget
import okhttp3.internal.wait

@Composable
fun CategoriesScreen(
    uiState: CategoriesContract.State,
    viewModel: CategoriesViewModel
) {
    LazyColumn(modifier = Modifier
        .padding(vertical = padding8)
    ) {
        items(items = uiState.categoriesList) { categoryModel ->
            viewModel.event(CategoriesContract.Event.GetProductsById(categoryModel.id))
            CategoryWidget(
                categoryName = categoryModel.name,
                productList = uiState.productsByCategoryIdList
            )
        }
    }
}