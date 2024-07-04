package com.mk_sofia.sofiamain.data.mappers

import com.mk_sofia.sofiamain.data.network.models.NetworkCategoryModel
import com.mk_sofia.sofiamain.domain.models.CategoryModel

fun List<NetworkCategoryModel>.toDomain(): List<CategoryModel> {
    val listCategoryModel = mutableListOf<CategoryModel>()
    this.forEach {
        listCategoryModel.add(
            CategoryModel(
                description = it.description,
                id = it.id,
                name = it.name
            )
        )
    }
    return listCategoryModel
}

