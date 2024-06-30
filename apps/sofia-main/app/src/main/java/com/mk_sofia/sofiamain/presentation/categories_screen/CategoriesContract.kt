package com.mk_sofia.sofiamain.presentation.categories_screen

import com.mk_sofia.sofiamain.core.base.BaseMVI
import com.mk_sofia.sofiamain.domain.models.CategoryModel


interface CategoriesContract : BaseMVI<
        CategoriesContract.State,
        CategoriesContract.Event,
        CategoriesContract.Effect
        > {

    data class State(
        val categories: List<CategoryModel>
    ) {
        companion object {
            fun initial() = State(
                categories = emptyList()
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