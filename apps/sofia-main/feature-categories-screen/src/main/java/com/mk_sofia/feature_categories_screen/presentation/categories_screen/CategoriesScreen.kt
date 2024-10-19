package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.core.ui.widgets.SofiaTopAppBar
import com.mk_sofia.feature_categories_screen.R
import com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets.CategoryWidget
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is CategoriesContract.UiState.Loading -> CircularProgressIndicator()
        is CategoriesContract.UiState.Success -> {
            CategoriesScreenUi(
                uiState = uiState
            )
        }
    }
}

@Composable
private fun CategoriesScreenUi(
    uiState: CategoriesContract.UiState,
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            SofiaTopAppBar(
                iconRes = R.drawable.ic_arrow_back_24,
                screenTitleRes = null,
                isNeedToShowIcon = true,
                isNeedToShowText = true,
                onTopBarButtonClick = { /*TODO*/ }
            )
        },
        content = { contentPadding ->
            CategoriesScreenContent(
                uiState = uiState,
                modifier = Modifier.padding(contentPadding)
            )
        }
    )
}

@Composable
private fun CategoriesScreenContent(
    uiState: CategoriesContract.UiState,
    modifier: Modifier = Modifier,
) {
    val successUiState = remember {
        uiState as CategoriesContract.UiState.Success
    }

    LazyColumn(
        modifier = modifier.padding(vertical = padding8)
    ) {
        items(items = successUiState.categoriesList) { categoryModel ->
            CategoryWidget(
                categoryName = categoryModel.name,
                productList = successUiState.productsByCategoryIdList
                    .filter {
                        it.categoryId == categoryModel.id
                    }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun UiPreview() {
    SofiaMainTheme {
        CategoriesScreenUi(
            uiState = CategoriesContract.UiState.Success(
                categoriesList = emptyList(),
                productsByCategoryIdList = emptyList()
            )
        )
    }
}