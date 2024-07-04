package com.mk_sofia.sofiamain.data.mappers

import com.mk_sofia.sofiamain.data.network.models.NetworkProductModel
import com.mk_sofia.sofiamain.domain.models.ProductModel

fun List<NetworkProductModel>.toDomain(): List<ProductModel> {
    val listProductModel = mutableListOf<ProductModel>()
    this.forEach {
        listProductModel.add(
            ProductModel(
                id = it.id,
                title = it.name,
                price = it.price,
                purchase = it.purchase,
                categoryId = it.categoryId,
                categoryName = it.categoryName,
                composition = it.composition,
                delivery = it.delivery,
                descriptionFull = it.descriptionFull,
                descriptionPreview = it.descriptionPreview,
                furniture = it.furniture,
                imageAll = it.imageAll,
                imagePreviewUrl = it.imagePreview,
            )
        )
    }
    return listProductModel
}