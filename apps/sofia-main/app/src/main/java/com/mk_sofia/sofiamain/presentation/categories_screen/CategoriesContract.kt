package com.mk_sofia.sofiamain.presentation.categories_screen

import com.mk_sofia.core.base.BaseMVI
import com.mk_sofia.sofiamain.domain.models.CategoryModel
import com.mk_sofia.sofiamain.domain.models.ProductModel


interface CategoriesContract : BaseMVI<
        CategoriesContract.State,
        CategoriesContract.Event,
        CategoriesContract.Effect
        > {

    data class State(
        val categoriesList: List<CategoryModel>,
        val productsByCategoryIdList: List<ProductModel>,
    ) {
        companion object {
            fun initial() = State(
                categoriesList = emptyList(),
                productsByCategoryIdList = emptyList(),
            )
        }
    }

    sealed interface Event {
        data object GetAllCategories : Event
        data class GetProductsById(val id: Int) : Event
    }

    sealed interface Effect {
        //TODO
    }

}