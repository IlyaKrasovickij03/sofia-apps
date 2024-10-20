package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
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
import com.mk_sofia.core.ui.theme.bodyRegular
import com.mk_sofia.core.ui.theme.darkText2
import com.mk_sofia.core.ui.theme.height64
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.theme.padding8
import com.mk_sofia.core.ui.widgets.SofiaTopAppBar
import com.mk_sofia.feature_categories_screen.R
import com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets.CategoryWidget
import com.mk_sofia.feature_categories_screen.presentation.categories_screen.widgets.ShimmerEffect
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is CategoriesContract.UiState.Loading -> {
            ShimmerContentUi()
        }

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
                screenTitleRes = R.string.top_bar_title,
                isNeedToShowIcon = true,
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
            .padding(vertical = padding8)
            .background(MaterialTheme.colorScheme.surfaceVariant),
    ) {
        item {
            ShopInfoDropDown(modifier = Modifier.padding(horizontal = padding16))
            Spacer(modifier = Modifier.height(12.dp))
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
private fun ShopInfoDropDown(
    modifier: Modifier = Modifier,
) {
    var isContentVisible by remember {
        mutableStateOf(false)
    }

    var isChecked by remember {
        mutableStateOf(false)
    }

    val newHeight = remember(isChecked) {
        if (isChecked) 4 else 1
    }

    val addedHeight = remember(isChecked) {
        if (isChecked) 24 else 0
    }

    val animatedHeight by animateDpAsState(
        targetValue = (56.dp * newHeight) + addedHeight.dp,
        animationSpec = tween(easing = FastOutSlowInEasing, durationMillis = 500),
        label = "ShopInfoDropDown"
    )

    val rotationAngle by animateFloatAsState(
        targetValue = if (isChecked) 180f else 0f,
        animationSpec = tween(easing = FastOutSlowInEasing, durationMillis = 500),
        label = "ArrowRotation"
    )

    LaunchedEffect(isChecked) {
        if (isChecked) {
            isContentVisible = true
        } else {
            delay(500)
            isContentVisible = false
        }
    }

    Card(
        modifier = modifier
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
                .height(24.dp)
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

        if (isContentVisible) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Адрес магазина: г. Казань, ул. Сибирский Тракт, 34, корп. 1, (этаж 3)",
                style = MaterialTheme.typography.bodyRegular,
                color = MaterialTheme.colorScheme.primaryContainer,
            )
            Spacer(modifier = Modifier.height(12.dp))
            LinkedText(
                modifier = Modifier.padding(horizontal = 16.dp),
                string = "mk-sofia.ru",
            )
            Spacer(modifier = Modifier.height(24.dp))
            ClickableIconWithText(
                iconRes = R.drawable.ic_logo_whatsapp_24,
                textRes = R.string.write_to_whatsapp,
                onClick = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.height(24.dp))
            ClickableIconWithText(
                iconRes = R.drawable.ic_logo_telegram_24,
                textRes = R.string.write_to_telegram,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Composable
private fun ClickableIconWithText(
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = stringResource(textRes),
            style = MaterialTheme.typography.bodyRegular,
            color = MaterialTheme.colorScheme.darkText2,
        )
    }
}

@Composable
private fun LinkedText(
    string: String,
    modifier: Modifier = Modifier,
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append(string)
        }
    }

    ClickableText(
        modifier = modifier
            .fillMaxWidth(),
        text = annotatedString,
        style = MaterialTheme.typography.bodyRegular,
        onClick = { },
    )
}

@Composable
private fun ShimmerContentUi() {
    Column(
        Modifier.fillMaxSize()
    ) {

        ShimmerEffect(modifier = Modifier
            .height(height64)
            .padding(horizontal = padding16)
        )

        ShimmerEffect(
            modifier = Modifier
                .height(56.dp)
                .padding(top = padding8)
                .padding(horizontal = padding16)
        )

        Spacer(modifier = Modifier.height(12.dp))

        ShimmerEffect(
            modifier = Modifier
                .height(255.dp)
                .padding(horizontal = padding16)
        )

        Spacer(modifier = Modifier.height(52.dp))

        ShimmerEffect(
            modifier = Modifier
                .height(255.dp)
                .padding(horizontal = padding16)
        )

        Spacer(modifier = Modifier.height(52.dp))

        ShimmerEffect(
            modifier = Modifier
                .height(255.dp)
                .padding(horizontal = padding16)
        )
    }
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