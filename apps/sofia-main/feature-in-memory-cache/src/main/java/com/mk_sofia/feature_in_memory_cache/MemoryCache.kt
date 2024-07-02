package com.mk_sofia.feature_in_memory_cache

import android.graphics.Bitmap
import androidx.collection.LruCache

val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
val cacheSize = maxMemory / 8

val imageMemoryCache = object : LruCache<String, Bitmap>(cacheSize) {

}