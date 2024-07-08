package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets.CategoryWidget
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState) {
        is CategoriesContract.UiState.Loading -> CircularProgressIndicator()
        is CategoriesContract.UiState.Success -> {
            LazyColumn(modifier = Modifier
                .padding(vertical = padding8)
            ) {
                items(items = (uiState as CategoriesContract.UiState.Success).categoriesList)
                { categoryModel ->
                    CategoryWidget(
                        categoryName = categoryModel.name,
                        productList = (uiState as CategoriesContract.UiState.Success)
                            .productsByCategoryIdList
                            .filter {
                            it.categoryId == categoryModel.id
                        }
                    )
                }
            }
        }
    }
    LaunchedEffect(true) {

    }


}