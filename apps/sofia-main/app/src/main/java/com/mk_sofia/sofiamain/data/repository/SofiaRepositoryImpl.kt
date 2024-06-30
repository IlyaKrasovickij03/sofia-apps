package com.mk_sofia.sofiamain.data.repository

import com.mk_sofia.sofiamain.data.mappers.toDomain
import com.mk_sofia.sofiamain.data.network.api.SofiaNetworkApi
import com.mk_sofia.sofiamain.domain.models.CategoryModel
import com.mk_sofia.sofiamain.domain.repository.SofiaRepository

class SofiaRepositoryImpl(
    private val sofiaApi: SofiaNetworkApi,
) : SofiaRepository {
    override suspend fun getAllCategories(): List<CategoryModel> {
        val allNetworkCategories = sofiaApi.getAllCategories()
        return allNetworkCategories.toDomain()
    }
}