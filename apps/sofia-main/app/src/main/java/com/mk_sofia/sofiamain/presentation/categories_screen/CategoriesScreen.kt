package com.mk_sofia.sofiamain.presentation.categories_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun CategoriesScreen(
    uiState: CategoriesContract.State,
) {
    LazyColumn {
        items(uiState.categories) {
            CategoryWidget(
                categoryId = it.id.toString(),
                categoryName = it.name,
                categoryDesc = it.description
            )
        }
    }
}