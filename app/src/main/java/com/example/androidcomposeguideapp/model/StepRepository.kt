package com.example.androidcomposeguideapp.model

import com.example.androidcomposeguideapp.R

object StepRepository {
    val steps = listOf<Step>(
        Step(
            stepName = R.string.step_one_name,
            stepInfo = R.string.step_one_info,
            stepImg = R.drawable.new_project_1,
        ),
        Step(
            stepName = R.string.step_two_name,
            stepInfo = R.string.step_two_info,
            stepImg = R.drawable.configure_project_2,
        ),
    )
}