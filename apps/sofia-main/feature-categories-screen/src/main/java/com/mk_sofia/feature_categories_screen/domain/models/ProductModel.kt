package com.mk_sofia.feature_categories_screen.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//data class ProductModel(
//    val id: Int,
//    val title: String,
//    val price: Int,
//    val purchase: String,
//    val categoryId: Int,
//    val categoryName: String,
//    val composition: String,
//    val delivery: String,
//    val descriptionFull: String,
//    val descriptionPreview: String,
//    val furniture: String,
//    val imageAll: List<String>,
//    val imagePreviewUrl: String,
//)

@Serializable
data class ProductModel(
    @SerialName("id")
    val id: Int,
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("name")
    val name: String,
)