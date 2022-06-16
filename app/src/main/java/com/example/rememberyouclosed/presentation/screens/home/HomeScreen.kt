package com.example.rememberyouclosed.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.*
import com.example.rememberyouclosed.R
import com.example.rememberyouclosed.presentation.theme.RememberYouClosedTheme

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val locks = viewModel.locks.collectAsState(initial = listOf()).value

    Scaffold(
        timeText = {
            TimeText()
        },
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        ScalingLazyColumn(
            anchorType = ScalingLazyListAnchorType.ItemCenter,
            autoCentering = true,
            content = {
                items(locks) {
                    Text(text = it.title!!)
                }
                item {
                    Chip(
                        label = { Text(text = stringResource(id = R.string.add_new_lock)) },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_add_24),
                                contentDescription = null
                            )
                        },
                        colors = ChipDefaults.chipColors(
                            backgroundColor = Color.Transparent
                        ),
                        onClick = { /*TODO*/ }
                    )
                }
            }
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun HomePreview() {
    RememberYouClosedTheme {
        HomeScreen()
    }
}