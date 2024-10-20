package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.bodyBold
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.core.ui.widgets.SofiaTopAppBar
import com.mk_sofia.feature_categories_screen.R
import com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets.CategoryWidget
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is CategoriesContract.UiState.Loading -> CircularProgressIndicator()
        is CategoriesContract.UiState.Success -> {
            CategoriesScreenUi(
                uiState = uiState
            )
        }
    }
}

@Composable
private fun CategoriesScreenUi(
    uiState: CategoriesContract.UiState,
) {
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        topBar = {
            SofiaTopAppBar(
                iconRes = R.drawable.ic_arrow_back_24,
                screenTitleRes = null,
                isNeedToShowIcon = true,
                isNeedToShowText = true,
                onTopBarButtonClick = { /*TODO*/ }
            )
        },
        content = { contentPadding ->
            CategoriesScreenContent(
                uiState = uiState,
                modifier = Modifier.padding(contentPadding)
            )
        }
    )
}

@Composable
private fun CategoriesScreenContent(
    uiState: CategoriesContract.UiState,
    modifier: Modifier = Modifier,
) {
    val successUiState = remember {
        uiState as CategoriesContract.UiState.Success
    }

    LazyColumn(
        modifier = modifier
            .padding(vertical = padding8, horizontal = padding16)
            .background(MaterialTheme.colorScheme.surfaceVariant),
    ) {
        item {
            ShopInfoDropDown()
            Spacer(modifier = Modifier.height(9.dp))
        }
        items(items = successUiState.categoriesList) { categoryModel ->
            CategoryWidget(
                categoryName = categoryModel.name,
                productList = successUiState.productsByCategoryIdList
                    .filter {
                        it.categoryId == categoryModel.id
                    }
            )
        }
    }
}

@Composable
private fun ShopInfoDropDown() {
    var isChecked by remember {
        mutableStateOf(false)
    }

    val newHeight = remember(isChecked) {
        if (isChecked) 5 else 1
    }

    val animatedHeight by animateDpAsState(
        targetValue = 56.dp * newHeight,
        animationSpec = tween(easing = FastOutSlowInEasing, durationMillis = 500),
        label = "ShopInfoDropDown"
    )

    val rotationAngle by animateFloatAsState(
        targetValue = if (isChecked) 180f else 0f,
        animationSpec = tween(easing = FastOutSlowInEasing, durationMillis = 500),
        label = "ArrowRotation"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(animatedHeight),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.shop_info),
                style = MaterialTheme.typography.bodyBold,
                color = MaterialTheme.colorScheme.surface
            )
            IconButton(
                onClick = {
                    isChecked = !isChecked
                }
            ) {
                Icon(
                    modifier = Modifier.rotate(rotationAngle),
                    painter = painterResource(R.drawable.ic_arrow_24),
                    tint = MaterialTheme.colorScheme.surface,
                    contentDescription = null,
                )
            }
        }

        if (isChecked) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Адрес магазина: г. Казань, ул. Сибирский Тракт, 34, корп. 1, (этаж 3)",
                style = MaterialTheme.typography.bodyBold,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Адрес магазина: г. Казань, ул. Сибирский Тракт, 34, корп. 1, (этаж 3)",
                style = MaterialTheme.typography.bodyBold,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun LinkedText(
    string: String,
    modifier: Modifier = Modifier,
) {
    val annotatedString = buildAnnotatedString {
        //pushStringAnnotation(tag = PROCESSING_PERSONAL_DATA_TAG, annotation = PROCESSING_PERSONAL_DATA_URI)
        withStyle(style = SpanStyle(color = AtiTheme.colors.accent, textDecoration = TextDecoration.Underline)) {
            append(stringResource(id = R.string.consent_to_the_processing_of_personal_data))
        }
        pop()
    }

    ClickableText(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        text = annotatedString,
        style = ,
        onClick = { },
        },
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun UiPreview() {
    SofiaMainTheme {
        CategoriesScreenUi(
            uiState = CategoriesContract.UiState.Success(
                categoriesList = emptyList(),
                productsByCategoryIdList = emptyList()
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ShopInfoDropDownPreview() {
    SofiaMainTheme {
        ShopInfoDropDown()
    }
}