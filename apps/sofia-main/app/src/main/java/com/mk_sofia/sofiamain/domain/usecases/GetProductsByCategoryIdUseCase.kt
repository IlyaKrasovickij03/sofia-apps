package com.mk_sofia.sofiamain.domain.usecases

import com.mk_sofia.sofiamain.domain.models.ProductModel
import com.mk_sofia.sofiamain.domain.repository.SofiaRepository

class GetProductsByCategoryIdUseCase (
    private val sofiaRepository: SofiaRepository
) {
    suspend fun execute(categoryId: Int): List<ProductModel> {
        return sofiaRepository.getProductsByCategoryId(categoryId = categoryId)
    }
}