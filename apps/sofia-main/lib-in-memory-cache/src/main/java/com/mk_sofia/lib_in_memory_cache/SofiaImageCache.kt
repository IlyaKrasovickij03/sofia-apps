package com.mk_sofia.lib_in_memory_cache

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.collection.LruCache
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

object SofiaImageCache {
    private val coroutineCacheScope = CoroutineScope(context = Dispatchers.IO)

    private val imageCache = object : LruCache<String, Bitmap>(100) {
        override fun sizeOf(key: String, value: Bitmap): Int {
            return super.sizeOf(key, value)
        }
    }

    fun load(imageUrl: String) {
        coroutineCacheScope.launch {
            val url = URL(imageUrl)
            val imageBitmap = BitmapFactory.decodeStream(url.openStream())
            withContext(Dispatchers.Main) {
                imageCache.put(imageUrl, imageBitmap)
            }
        }
    }

    fun get(imageId: String): Bitmap? {
        return imageCache.get(imageId)
    }
}

