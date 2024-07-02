package com.mk_sofia.sofiamain.presentation.categories_screen.widgets

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mk_sofia.core.ui.theme.SofiaMainTheme

@Composable
fun CategoryWidget(
    categoryId: String,
    categoryName: String,
    categoryDesc: String,

) {
    Card() {
        Text(text = categoryId)
        Text(text = categoryName)
        Text(text = categoryDesc)
    }
}

@Preview
@Composable
private fun CategoryWidgetPreview() {
    SofiaMainTheme {
        CategoryWidget(
            categoryId = "1",
            categoryName = "Шкафы",
            categoryDesc = "Крутые"
        )
    }
}