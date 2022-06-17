@file:OptIn(ExperimentalWearMaterialApi::class)

package com.example.rememberyouclosed.presentation.screens.add_new_lock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.*
import com.example.rememberyouclosed.R
import com.example.rememberyouclosed.presentation.theme.Grey500
import com.example.rememberyouclosed.presentation.theme.RememberYouClosedTheme
import com.example.rememberyouclosed.presentation.util.Constants
import com.example.rememberyouclosed.presentation.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun AddNewLockScreen(
    viewModel: AddNewLockViewModel = hiltViewModel(),
    onPopBackStack: (UiEvent.PopBackStack) -> Unit
) {

    LaunchedEffect(key1 = true, block = {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> {
                    onPopBackStack(event)
                }
                else -> Unit
            }
        }
    })

    AddNewLockContent(
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun AddNewLockContent(
    onEvent: (AddNewLockScreenEvents) -> Unit
) {
    Scaffold(
        timeText = {
            TimeText()
        },
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        ScalingLazyColumn(
            content = {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = CenterHorizontally)
                            .padding(ChipDefaults.ContentPadding)
                    ) {
                        Text(
                            text = stringResource(id = R.string.add_new_lock),
                        )
                    }

                }
                items(Constants.lockCategories) { category ->
                    Chip(
                        label = {
                            Text(text = category.title)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = category.icon),
                                contentDescription = category.title
                            )
                        },
                        colors = ChipDefaults.chipColors(
                            backgroundColor = Grey500
                        ),
                        onClick = { onEvent(AddNewLockScreenEvents.OnCategoryClick(category)) }
                    )
                }
            }
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
private fun AddNewLockPreview() {
    RememberYouClosedTheme {
        AddNewLockContent(onEvent = {})
    }
}