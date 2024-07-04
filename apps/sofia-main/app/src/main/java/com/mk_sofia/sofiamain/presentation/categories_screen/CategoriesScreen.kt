package com.mk_sofia.sofiamain.presentation.categories_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.sofiamain.presentation.categories_screen.widgets.CategoryWidget
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(modifier = Modifier
        .padding(vertical = padding8)
    ) {
        items(items = uiState.categoriesList) { categoryModel ->
            CategoryWidget(
                categoryName = categoryModel.name,
                productList = uiState.productsByCategoryIdList
            )
        }
    }
}