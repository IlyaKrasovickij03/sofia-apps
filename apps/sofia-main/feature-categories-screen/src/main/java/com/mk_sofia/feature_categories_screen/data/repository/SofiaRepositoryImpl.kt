package com.mk_sofia.feature_categories_screen.data.repository

import com.mk_sofia.feature_categories_screen.data.mappers.toDomain
import com.mk_sofia.feature_categories_screen.data.network.api.CategoriesScreenNetworkApi
import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository

class SofiaRepositoryImpl(
    private val sofiaApi: CategoriesScreenNetworkApi,
) : SofiaRepository {
    override suspend fun getAllCategories(): List<CategoryModel> {
        val allNetworkCategories = sofiaApi.getAllCategories()
        return allNetworkCategories.toDomain()
    }

    override suspend fun getProductsByCategoryId(categoryId: Int): List<ProductModel> {
        val productModels = sofiaApi.getProductsByCategoryId(id = categoryId)
        return productModels.toDomain()
    }
}