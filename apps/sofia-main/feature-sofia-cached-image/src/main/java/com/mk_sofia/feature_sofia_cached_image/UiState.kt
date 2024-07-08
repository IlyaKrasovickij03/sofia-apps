package com.mk_sofia.feature_sofia_cached_image

import androidx.compose.ui.graphics.ImageBitmap

sealed interface UiState{
    data class Success(
        val imageBitmap: ImageBitmap,
    ) : UiState
    data object Loading : UiState
}