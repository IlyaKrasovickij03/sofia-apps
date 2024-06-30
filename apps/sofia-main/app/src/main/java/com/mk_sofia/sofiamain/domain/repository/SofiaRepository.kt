package com.mk_sofia.sofiamain.domain.repository

import com.mk_sofia.sofiamain.domain.models.CategoryModel

interface SofiaRepository {
    suspend fun getAllCategories(): List<CategoryModel>
}