package com.example.rememberyouclosed.presentation.util

import com.example.rememberyouclosed.R
import com.example.rememberyouclosed.domain.model.LockCategory

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
    )
}