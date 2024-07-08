package com.mk_sofia.feature_sofia_cached_image

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk_sofia.core.extensions.launchOnIo
import com.mk_sofia.lib_in_memory_cache.SofiaImageCache
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.URL



class CachedImageViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)

    val uiState = _uiState.asStateFlow()

    fun getImageByUrl(imageUrl: String) {
        viewModelScope.launchOnIo {
            if (getSavedImageFromCache(imageUrl) == null) {
                val url = URL(imageUrl)
                val imageBitmap = BitmapFactory.decodeStream(url.openStream()).asImageBitmap()
                _uiState.update {
                    UiState.Success(
                        imageBitmap = imageBitmap
                    )
                }
            } else {
                val imageBitmap = SofiaImageCache.get(imageUrl)!!.asImageBitmap()
                _uiState.update {
                    UiState.Success(
                        imageBitmap = imageBitmap
                    )
                }
            }
        }
    }

    private fun getSavedImageFromCache(imageUrl: String): ImageBitmap? {
        val imageBitmap = SofiaImageCache.get(imageUrl)?.asImageBitmap()
        if (imageBitmap != null) {
            return imageBitmap
        } else {
            tryToGetCachedImage(imageUrl)
            return null
        }
    }

    private fun tryToGetCachedImage(imageUrl: String): ImageBitmap? {
        return SofiaImageCache.get(imageUrl)?.asImageBitmap()
    }
}