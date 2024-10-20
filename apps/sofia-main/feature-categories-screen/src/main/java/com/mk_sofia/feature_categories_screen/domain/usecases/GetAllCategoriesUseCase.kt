package com.mk_sofia.feature_categories_screen.domain.usecases

import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository

class GetAllCategoriesUseCase(
    private val sofiaRepository: SofiaRepository
) {
    suspend fun execute() = sofiaRepository.getAllCategories()
}