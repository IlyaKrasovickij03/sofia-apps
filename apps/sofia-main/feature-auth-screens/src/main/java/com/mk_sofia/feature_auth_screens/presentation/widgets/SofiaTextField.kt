package com.mk_sofia.feature_auth_screens.presentation.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mk_sofia.core.ui.theme.cornerRadius5
import com.mk_sofia.core.ui.theme.height24
import com.mk_sofia.core.ui.theme.height44
import com.mk_sofia.core.ui.theme.height6
import com.mk_sofia.core.ui.theme.height64
import com.mk_sofia.core.ui.theme.padding10
import com.mk_sofia.core.ui.theme.padding20

@Composable
fun SofiaTextField(
    containerColor: Color,
    placeHolderTextColor: Color,
    placeHolderTextId: Int,
    placeHolderTextStyle: TextStyle,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = "",
        placeholder = {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = stringResource(id = placeHolderTextId),
                style = placeHolderTextStyle,
                color = placeHolderTextColor
            )
        },
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
            cursorColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(cornerRadius5),
        textStyle = placeHolderTextStyle
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SofiaTextField2(
    value: String,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    placeHolderTextColor: Color = MaterialTheme.colorScheme.primaryContainer,
    placeHolderTextId: Int,
    placeHolderTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(height44),
        value = TextFieldValue(

        ),
        onValueChange = {
            onValueChange(
                it.text
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(horizontal = padding20, vertical = padding10),
                placeholder = {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            text = stringResource(id = placeHolderTextId),
                            style = placeHolderTextStyle,
                            color = placeHolderTextColor
                        )
                    }
                },
                container = {
                    TextFieldDefaults.OutlinedBorderContainerBox(
                        enabled = true,
                        isError = false,
                        interactionSource = interactionSource,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = containerColor,
                            unfocusedContainerColor = containerColor,
                            disabledContainerColor = containerColor,
                            focusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
                            cursorColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        shape = RoundedCornerShape(cornerRadius5),
                    )
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SofiaTextField3(
    value: String,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    placeHolderTextColor: Color = MaterialTheme.colorScheme.primaryContainer,
    placeHolderTextId: Int,
    placeHolderTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    titleId: Int,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column {
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(id = titleId),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.surface,
        )
        Spacer(modifier = Modifier.height(height6))
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(height44),
            value = TextFieldValue(

            ),
            onValueChange = {
                onValueChange(
                    it.text
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            decorationBox = { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(horizontal = padding20, vertical = padding10),
                    placeholder = {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                text = stringResource(id = placeHolderTextId),
                                style = placeHolderTextStyle,
                                color = placeHolderTextColor
                            )
                        }
                    },
                    container = {
                        TextFieldDefaults.OutlinedBorderContainerBox(
                            enabled = true,
                            isError = false,
                            interactionSource = interactionSource,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = containerColor,
                                unfocusedContainerColor = containerColor,
                                disabledContainerColor = containerColor,
                                focusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                cursorColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            shape = RoundedCornerShape(cornerRadius5),
                        )
                    }
                )
            }
        )
    }
}