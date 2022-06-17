package com.example.rememberyouclosed.presentation.screens.update_lock_status

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Stepper
import androidx.wear.compose.material.Text
import com.example.rememberyouclosed.R
import com.example.rememberyouclosed.domain.mappers.asString
import com.example.rememberyouclosed.domain.mappers.lockStatusFromInt
import com.example.rememberyouclosed.domain.model.Lock
import com.example.rememberyouclosed.domain.model.LockStatus
import com.example.rememberyouclosed.presentation.theme.RememberYouClosedTheme

@Composable
fun UpdateLockStatusScreen(viewModel: UpdateLockStatusViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState().value

    UpdateLockStatusContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun UpdateLockStatusContent(
    state: UpdateLockStatusScreenState,
    onEvent: (UpdateLockStatusScreenEvents) -> Unit
) {
    Stepper(
        value = state.stepperValue,
        onValueChange = {
            onEvent(UpdateLockStatusScreenEvents.ToggleStepperValue(it))
        },
        valueProgression = (0..1),
        increaseIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_lock_24),
                contentDescription = stringResource(
                    id = R.string.locked
                )
            )
        },
        decreaseIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_lock_open_24),
                contentDescription = stringResource(
                    id = R.string.unlocked
                )
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.lock?.let { lock ->
                Text(
                    text = lock.title!!,
                    fontSize = MaterialTheme.typography.title1.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = lockStatusFromInt(state.stepperValue).asString(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun UpdateLockStatusPreview() {
    val lock = Lock(title = "Home", icon = R.drawable.ic_round_home_24, status = LockStatus.LOCKED)

    RememberYouClosedTheme {
        UpdateLockStatusContent(
            state = UpdateLockStatusScreenState(lock, stepperValue = 0),
            onEvent = {}
        )
    }
}