package com.mk_sofia.sofiamain.presentation.categories_screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.sofiamain.domain.models.CategoryModel
import com.mk_sofia.sofiamain.domain.models.ProductModel
import com.mk_sofia.sofiamain.presentation.categories_screen.widgets.CategoryWidget
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
                    Log.d("AAAAAAAA_CATEGORIES_NAMES", "id"+categoryModel.id.toString())
                    (uiState as CategoriesContract.UiState.Success).productsByCategoryIdList.forEach {
                        Log.d("AAAAAAAA_CATEGORIES_NAMES", "${mapOf(categoryModel.id to it.categoryId)} правда ли: ${if(categoryModel.id == it.categoryId) "true" else "false"}")
                    }
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