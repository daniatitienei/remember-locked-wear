package com.atitienei_daniel.rememberlocked.presentation.util

import com.atitienei_daniel.rememberlocked.domain.model.LockCategory
import com.atitienei_daniel.rememberlocked.R

object Constants {
    val lockCategories = listOf(
        LockCategory(
            title = "Home",
            icon = R.drawable.ic_round_home_24
        ),
        LockCategory(
            title = "Car",
            icon = R.drawable.ic_round_directions_car_24
        ),
        LockCategory(
            title = "Lights",
            icon = R.drawable.lightbulb
        ),
        LockCategory(
            title = "Gas",
            icon = R.drawable.gas_meter

        ),
        LockCategory(
            title = "Water",
            icon = R.drawable.water_drop
        )
    )
}