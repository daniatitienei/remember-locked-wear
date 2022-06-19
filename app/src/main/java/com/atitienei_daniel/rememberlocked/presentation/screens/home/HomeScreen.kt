package com.atitienei_daniel.rememberlocked.presentation.screens.home

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.*
import com.atitienei_daniel.rememberlocked.R
import com.atitienei_daniel.rememberlocked.domain.mappers.asString
import com.atitienei_daniel.rememberlocked.domain.model.Lock
import com.atitienei_daniel.rememberlocked.domain.model.LockStatus
import com.atitienei_daniel.rememberlocked.presentation.theme.Grey500
import com.atitienei_daniel.rememberlocked.presentation.theme.RememberYouClosedTheme
import com.atitienei_daniel.rememberlocked.presentation.util.UiEvent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (UiEvent.Navigate) -> Unit
) {

    val locks = viewModel.locks.collectAsState(initial = listOf()).value

    LaunchedEffect(key1 = true, block = {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
                else -> Unit
            }
        }
    })

    HomeContent(
        locks = locks,
        onEvent = viewModel::onEvent
    )
}

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
private fun HomeContent(
    locks: List<Lock>,
    onEvent: (HomeScreenEvents) -> Unit
) {
    Scaffold(
        timeText = {
            TimeText()
        },
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        ScalingLazyColumn(
            anchorType = ScalingLazyListAnchorType.ItemCenter,
            autoCentering = true,
            modifier = Modifier.animateContentSize(tween(200)),
            content = {
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
                        onClick = { onEvent(HomeScreenEvents.OnAddNewLockClick) }
                    )
                }
                items(locks) { lock ->
                    Chip(
                        label = { Text(text = lock.title!!) },
                        secondaryLabel = { Text(text = lock.status?.asString()!!) },
                        icon = {
                            lock.icon?.let { icon ->
                                Icon(
                                    painter = painterResource(id = icon),
                                    contentDescription = null
                                )
                            }
                        },
                        colors = ChipDefaults.chipColors(
                            backgroundColor = Grey500
                        ),
                        onClick = {
                            onEvent(HomeScreenEvents.OnLockClick(lock.id!!))
                        }
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
        HomeContent(
            locks = listOf(
                Lock(
                    title = "Home",
                    status = LockStatus.LOCKED,
                    icon = R.drawable.ic_round_home_24
                ),
                Lock(
                    title = "Car",
                    status = LockStatus.LOCKED,
                    icon = R.drawable.ic_round_directions_car_24
                )
            ),
            onEvent = {}
        )
    }
}