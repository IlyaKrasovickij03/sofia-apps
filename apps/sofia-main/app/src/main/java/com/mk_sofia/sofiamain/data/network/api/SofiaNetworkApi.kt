package com.mk_sofia.sofiamain.data.network.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mk_sofia.sofiamain.data.network.models.NetworkCategoryModel
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

interface SofiaNetworkApi {
    @GET("/api/category")
    suspend fun getAllCategories(): List<NetworkCategoryModel>
}

fun SofiaNetworkApi(): SofiaNetworkApi {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val sofiaClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    val jsonConverter = Json.asConverterFactory("application/json".toMediaType())

    val baseUrl = HttpUrl.Builder()
        .scheme("http")
        .host("77.232.139.227")
        .build()


    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverter)
        .client(sofiaClient)
        .build()

    return retrofit.create()
}