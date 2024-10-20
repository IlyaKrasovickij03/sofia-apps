package com.mk_sofia.feature_categories_screen.domain.usecases

import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository

class GetProductsByCategoryIdWithLimitUseCase(
    private val sofiaRepository: SofiaRepository
) {
    suspend fun execute(categoryId: Int, limit: Long): List<ProductModel> {
        return sofiaRepository.getProductsByCategoryIdWithLimit(
            categoryId = categoryId,
            limit = limit
        )
    }
}