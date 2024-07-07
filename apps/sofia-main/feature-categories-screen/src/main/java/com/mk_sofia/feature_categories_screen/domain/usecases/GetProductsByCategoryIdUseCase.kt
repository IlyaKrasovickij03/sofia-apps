package com.mk_sofia.feature_categories_screen.domain.usecases

import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository

class GetProductsByCategoryIdUseCase (
    private val sofiaRepository: SofiaRepository
) {
    suspend fun execute(categoryId: Int): List<ProductModel> {
        return sofiaRepository.getProductsByCategoryId(categoryId = categoryId)
    }
}