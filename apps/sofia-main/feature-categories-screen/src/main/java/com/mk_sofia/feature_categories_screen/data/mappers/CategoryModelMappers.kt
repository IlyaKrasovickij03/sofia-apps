package com.mk_sofia.feature_categories_screen.data.mappers

import com.mk_sofia.feature_categories_screen.data.network.models.NetworkCategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel

fun List<NetworkCategoryModel>.toDomain(): List<CategoryModel> {
    return this.map {
        CategoryModel(
            id = it.id,
            name = it.name
        )
    }
}

