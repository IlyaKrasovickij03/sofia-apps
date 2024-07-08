package com.mk_sofia.feature_sofia_cached_image

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mk_sofia.lib_in_memory_cache.SofiaImageCache
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel


@Composable
fun SofiaCachedImage(
    imageUrl: String,
    success: @Composable (ImageBitmap) -> Unit,
    //error: @Composable () -> Unit,
    viewModel: CachedImageViewModel = koinViewModel()
) {
    LaunchedEffect(imageUrl) {
        viewModel.getImageByUrl(imageUrl)
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState) {
        is UiState.Success -> success((uiState as UiState.Success).imageBitmap)
        is UiState.Loading -> CircularProgressIndicator()
    }
}

@Preview
@Composable
private fun SofiaCachedImagePreview() {

}