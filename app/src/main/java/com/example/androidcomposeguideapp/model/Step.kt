package com.example.androidcomposeguideapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Step(
    @StringRes val stepName: Int,
    @StringRes val stepInfo: Int,
    @DrawableRes val stepImg: Int
)