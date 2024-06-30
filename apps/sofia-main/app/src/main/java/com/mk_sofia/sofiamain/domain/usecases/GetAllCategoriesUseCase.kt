package com.mk_sofia.sofiamain.domain.usecases

import com.mk_sofia.sofiamain.domain.repository.SofiaRepository

class GetAllCategoriesUseCase(
    private val sofiaRepository: SofiaRepository
) {
    suspend fun execute() = sofiaRepository.getAllCategories()
}