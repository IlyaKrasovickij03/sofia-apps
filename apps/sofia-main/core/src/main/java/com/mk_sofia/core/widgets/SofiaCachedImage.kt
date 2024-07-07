package com.mk_sofia.core.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.lib_in_memory_cache.SofiaImageCache


@Composable
fun SofiaCachedImage(
    imageUrl: String,
    success: @Composable (ImageBitmap) -> Unit,
    error: @Composable () -> Unit,
) {
    val imageBitmap = SofiaImageCache.get(imageUrl)?.asImageBitmap()
    if (imageBitmap != null) {
        success(imageBitmap)
    } else {
        SofiaImageCache
            .load(imageUrl = imageUrl)
    }
}

@Preview
@Composable
private fun SofiaCachedImagePreview() {

}