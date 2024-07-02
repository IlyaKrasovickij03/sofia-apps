package com.mk_sofia.sofiamain.presentation.categories_screen

import com.mk_sofia.core.base.BaseMVI
import com.mk_sofia.sofiamain.domain.models.CategoryModel


interface CategoriesContract : com.mk_sofia.core.base.BaseMVI<
        CategoriesContract.State,
        CategoriesContract.Event,
        CategoriesContract.Effect
        > {

    data class State(
        val categoriesList: List<CategoryModel>
    ) {
        companion object {
            fun initial() = State(
                categoriesList = emptyList()
            )
        }
    }

    sealed interface Event {
        data object GetAllCategories : Event
    }

    sealed interface Effect {
        //TODO
    }

}