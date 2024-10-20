package com.mk_sofia.feature_categories_screen.data.network

import com.google.firebase.database.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mk_sofia.core.FirestoreCollections
import com.mk_sofia.feature_categories_screen.data.network.models.NetworkCategoryModel
import com.mk_sofia.feature_categories_screen.data.network.models.NetworkProductModel
import kotlinx.coroutines.tasks.await
import com.google.firebase.firestore.Query.Direction

class CategoriesScreenApi {
    private val database = Firebase.firestore

    suspend fun getAllCategories(): List<NetworkCategoryModel> {
        val snapshot = database.collection(FirestoreCollections.CATEGORIES.collectionName)
            .get()
            .await()

        return snapshot.toObjects(NetworkCategoryModel::class.java)
    }

    suspend fun getProductsByCategoryId(id: Int): List<NetworkProductModel> {
        val snapshot = database.collection(FirestoreCollections.PRODUCTS.collectionName)
            .whereEqualTo("categoryId", id)
            .get()
            .await()

        return snapshot.toObjects(NetworkProductModel::class.java)
    }

    suspend fun getProductsByCategoryIdWithLimit(id: Int, limit: Long): List<NetworkProductModel> {
        val snapshot = database.collection(FirestoreCollections.PRODUCTS.collectionName)
            .whereEqualTo("categoryId", id)
            .limit(limit)
            .orderBy("categoryId", Direction.DESCENDING)
            .get()
            .await()

        return snapshot.toObjects(NetworkProductModel::class.java)
    }
}