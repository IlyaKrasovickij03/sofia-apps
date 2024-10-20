package com.mk_sofia.feature_categories_screen.domain.repository

import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel

interface SofiaRepository {
    /**
     * Возвращает все существующие категории.
     */
    suspend fun getAllCategories(): List<CategoryModel>

    /**
     * Возвращает товары с определнным [categoryId].
     */
    suspend fun getProductsByCategoryId(categoryId: Int): List<ProductModel>

    /**
     * Возвращает [limit] количество товаров с определнным [categoryId].
     */
    suspend fun getProductsByCategoryIdWithLimit(categoryId: Int, limit: Long): List<ProductModel>
}