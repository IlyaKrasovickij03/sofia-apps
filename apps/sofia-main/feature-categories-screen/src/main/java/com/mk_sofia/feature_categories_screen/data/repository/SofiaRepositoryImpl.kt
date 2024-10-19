package com.mk_sofia.feature_categories_screen.data.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mk_sofia.feature_categories_screen.data.mappers.toDomain
import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository

class SofiaRepositoryImpl() : SofiaRepository {
    val database = FirebaseDatabase.getInstance().getReference("Sofia")
    override suspend fun doing() {

    }

//    override suspend fun getAllCategories(): List<CategoryModel> {
//        val allNetworkCategories = sofiaApi.getAllCategories()
//
//        return allNetworkCategories.toDomain()
//    }
//
//    override suspend fun getProductsByCategoryId(categoryId: Int): List<ProductModel> {
//        val productModels = sofiaApi.getProductsByCategoryId(id = categoryId)
//
//        return productModels.toDomain()
//    }
}