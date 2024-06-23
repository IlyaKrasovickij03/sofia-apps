package com.mk_sofia.sofiamain.presentation.categories_screen

import com.mk_sofia.sofiamain.core.base.BaseMVI

private const val EMPTY_STRING = ""

interface CategoriesContract : BaseMVI<
            CategoriesContract.State,
            CategoriesContract.Event,
            CategoriesContract.Effect
            > {

    data class State(
        val categoryName: String
    ) {
        companion object {
            fun initial() = State(
                categoryName = EMPTY_STRING
            )
         }
    }

    sealed interface Event {

    }

    sealed interface Effect {

    }

}