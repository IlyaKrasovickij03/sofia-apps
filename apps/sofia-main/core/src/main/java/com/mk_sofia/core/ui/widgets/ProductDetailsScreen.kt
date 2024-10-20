package com.mk_sofia.core.ui.widgets

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mk_sofia.core.R
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.core.ui.theme.bodyBold
import com.mk_sofia.core.ui.theme.bodyRegular
import com.mk_sofia.core.ui.theme.captionRegular
import com.mk_sofia.core.ui.theme.iconDark
import com.mk_sofia.core.ui.theme.lightGrayCard
import com.mk_sofia.core.ui.theme.padding12
import com.mk_sofia.core.ui.theme.padding16
import com.mk_sofia.core.ui.theme.sofiaGreen

@Composable
fun ProductDetailsScreen() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 56.dp)
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            ImageBlock()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                modifier = Modifier
                    .padding(horizontal = padding16),
                text = "Шкаф-купе для прихожей",
                style = MaterialTheme.typography.bodyBold,
                color = MaterialTheme.colorScheme.surface
            )

            Spacer(modifier = Modifier.height(27.dp))

            MaterialDetailsCard(modifier = Modifier.padding(horizontal = padding16))

            Spacer(modifier = Modifier.height(32.dp))

            DescriptionBlock(modifier = Modifier.padding(horizontal = padding16))
        }

        SofiaCustomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .padding(bottom = 12.dp),
            textRes = R.string.add_to_cart,
            onClick = {},
        )
    }

}

@Composable
private fun DescriptionBlock(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        DescriptionDropDownMenu(
            modifier = Modifier,
            textRes = R.string.characteristics,
        )

        Spacer(modifier = Modifier.height(16.dp))

        DescriptionDropDownMenu(
            modifier = Modifier,
            textRes = R.string.description,
        )
    }
}

@Composable
private fun DescriptionDropDownMenu(
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
) {
    var isChecked by remember { mutableStateOf(false) }

    val rotationAngle by animateFloatAsState(
        targetValue = if (isChecked) 180f else 0f,
        animationSpec = tween(easing = FastOutSlowInEasing, durationMillis = 500),
        label = "ArrowRotation"
    )

    val iconRes = if (rotationAngle > 90f) R.drawable.ic_round_minus_24
    else R.drawable.ic_round_plus_24

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(textRes),
                style = MaterialTheme.typography.bodyBold,
                color = MaterialTheme.colorScheme.surface
            )

            IconButton(
                modifier = Modifier,
                onClick = {
                    isChecked = !isChecked
                },
            ) {
                Icon(
                    modifier = Modifier.rotate(rotationAngle),
                    painter = painterResource(id = iconRes),
                    tint = MaterialTheme.colorScheme.iconDark,
                    contentDescription = null,
                )
            }
        }

        AnimatedVisibility(
            visible = isChecked,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        )  {
            Text(
                modifier = Modifier
                    .padding(top = 12.dp),
                text = "Описание товара много строчек Описание товара много строчек  " +
                        "Описание товара много строчек  Описание товара много строчек  " +
                        "Описание товара много строчек  Описание товара много строчек " +
                        "Описание товара много строчек Описание товара много строчек " +
                        "Описание товара много строчек Описание товара много строчек " +
                        "Описание товара много строчек Описание товара много строчек " +
                        "Описание товара много строчек",
                style = MaterialTheme.typography.bodyRegular,
                color = MaterialTheme.colorScheme.primaryContainer
            )
        }
    }
}

@Composable
private fun MaterialDetailsCard(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .height(155.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.lightGrayCard),
        shape = RoundedCornerShape(21.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(top = padding16, start = padding16),
            text = "от 39 990 Р",
            style = MaterialTheme.typography.bodyBold,
            color = MaterialTheme.colorScheme.surface
        )

        Text(
            modifier = Modifier
                .padding(top = 4.dp, start = padding16),
            text = "В наличие 675 шт",
            style = MaterialTheme.typography.captionRegular,
            color = MaterialTheme.colorScheme.sofiaGreen
        )

        Spacer(modifier = Modifier.height(37.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = padding16)
                .fillMaxWidth()
                .height(44.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = padding16)
                    .padding(vertical = 10.dp),
                text = stringResource(R.string.materials_choosing_details),
                style = MaterialTheme.typography.bodyRegular,
                color = MaterialTheme.colorScheme.primaryContainer
            )

            IconButton(
                modifier = Modifier
                    .padding(end = padding16)
                    .padding(vertical = 10.dp),
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_next_24),
                    tint = MaterialTheme.colorScheme.iconDark,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
private fun ImageBlock() {
    Box {
        Image(
            modifier = Modifier
                .height(270.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.kitchen_test),
            contentDescription = null,
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
        ImageBlockTopBar(
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = padding16)
                .align(Alignment.TopCenter)
        )
        Counter(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun Counter(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(count = 4) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .height(12.dp)
                    .width(12.dp)
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant
                    ),
            )
        }
    }
}

@Composable
private fun ImageBlockTopBar(
    modifier: Modifier = Modifier,
) {
    var isChecked by remember { mutableStateOf(false) }

    val iconRes = if (isChecked) R.drawable.ic_like_active_24
    else R.drawable.ic_like_unactive_24

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(0.835f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .height(24.dp)
                    .width(24.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                onClick = { },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    tint = MaterialTheme.colorScheme.surface,
                    contentDescription = null,
                )
            }
        }



        Row(
            modifier = Modifier
                .weight(0.165f),
            horizontalArrangement = Arrangement.spacedBy(19.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                onClick = {
                    isChecked = !isChecked
                },
            ) {
                Icon(
                    painter = painterResource(id = iconRes),
                    tint = Color.Unspecified,
                    contentDescription = null,
                )
            }

            IconButton(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share_24),
                    tint = Color.Unspecified,
                    contentDescription = null,
                )
            }
        }


    }
}

@Composable
@Preview
fun ProductDetailsScreenPreview() {
    SofiaMainTheme {
        ProductDetailsScreen()
    }
}


@Composable
@Preview
fun ImageBlockPreview() {
    SofiaMainTheme {
        ImageBlock()
    }
}

@Composable
@Preview
fun MaterialDetailsCardPreview() {
    SofiaMainTheme {
        MaterialDetailsCard()
    }
}