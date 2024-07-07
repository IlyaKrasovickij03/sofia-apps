package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import com.mk_sofia.core.base.BaseMVI
import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel


interface CategoriesContract : BaseMVI<
        CategoriesContract.UiState,
        CategoriesContract.Event,
        CategoriesContract.Effect
        > {

    sealed interface UiState {
        data object Loading : UiState
        data class Success(
            val categoriesList: List<CategoryModel>,
            val productsByCategoryIdList: List<ProductModel>,) : UiState
    }

    sealed interface Event {
        data object UpdateProductsByCategories : Event
    }

    sealed interface Effect {
        //TODO
    }

}