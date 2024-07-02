package com.mk_sofia.sofiamain.domain.models

data class ProductModel(
    val id: Int,
    val name: String,
    val price: Int,
    val purchase: String,
    val categoryId: Int,
    val categoryName: String,
    val composition: String,
    val delivery: String,
    val descriptionFull: String,
    val descriptionPreview: String,
    val furniture: String,
    val imageAll: List<String>,
    val imagePreview: String,
)