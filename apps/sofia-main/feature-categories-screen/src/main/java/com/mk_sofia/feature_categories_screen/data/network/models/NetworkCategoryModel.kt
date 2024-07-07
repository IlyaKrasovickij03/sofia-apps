package com.mk_sofia.feature_categories_screen.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCategoryModel(
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
)
