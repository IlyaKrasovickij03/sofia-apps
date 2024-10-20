package com.mk_sofia.feature_categories_screen.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

//@Serializable
//data class NetworkProductModel(
//    @SerialName("id")
//    val id: Int,
//    @SerialName("name")
//    val name: String,
//    @SerialName("price")
//    val price: Int,
//    @SerialName("purchase")
//    val purchase: String,
//    @SerialName("category_id")
//    val categoryId: Int,
//    @SerialName("category_name")
//    val categoryName: String,
//    @SerialName("composition")
//    val composition: String,
//    @SerialName("delivery")
//    val delivery: String,
//    @SerialName("description_full")
//    val descriptionFull: String,
//    @SerialName("description_preview")
//    val descriptionPreview: String,
//    @SerialName("furniture")
//    val furniture: String,
//    @SerialName("image_all")
//    val imageAll: List<String>,
//    @SerialName("image_preview")
//    val imagePreview: String,
//)

@Serializable
data class NetworkProductModel(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("categoryId")
    val categoryId: Int = 0,
    @SerialName("name")
    val name: String = "",
)