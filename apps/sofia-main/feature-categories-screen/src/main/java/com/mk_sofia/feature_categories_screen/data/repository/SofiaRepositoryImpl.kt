package com.mk_sofia.feature_categories_screen.data.repository

import com.mk_sofia.feature_categories_screen.data.mappers.toDomain
import com.mk_sofia.feature_categories_screen.data.network.CategoriesScreenApi
import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository

class SofiaRepositoryImpl(
    private val categoriesScreenApi: CategoriesScreenApi,
) : SofiaRepository {
    override suspend fun getAllCategories(): List<CategoryModel> {
        val allNetworkCategories = categoriesScreenApi.getAllCategories()

        return allNetworkCategories.toDomain()
    }

    override suspend fun getProductsByCategoryId(categoryId: Int): List<ProductModel> {
        val productModels = categoriesScreenApi.getProductsByCategoryId(id = categoryId)

        return productModels.toDomain()
    }

    override suspend fun getProductsByCategoryIdWithLimit(
        categoryId: Int,
        limit: Long
    ): List<ProductModel> {
        val productModels = categoriesScreenApi.getProductsByCategoryIdWithLimit(
            id = categoryId,
            limit = limit
        )

        return productModels.toDomain()
    }
}