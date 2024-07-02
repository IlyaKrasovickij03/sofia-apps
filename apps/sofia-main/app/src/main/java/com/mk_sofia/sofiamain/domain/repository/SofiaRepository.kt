package com.mk_sofia.sofiamain.domain.repository

import com.mk_sofia.sofiamain.domain.models.CategoryModel
import com.mk_sofia.sofiamain.domain.models.ProductModel

interface SofiaRepository {
    suspend fun getAllCategories(): List<CategoryModel>

    suspend fun getProductsByCategoryId(categoryId: Int): List<ProductModel>
}