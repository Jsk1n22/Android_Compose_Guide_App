package com.example.androidcomposeguideapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcomposeguideapp.model.Step
import com.example.androidcomposeguideapp.model.StepRepository
import com.example.androidcomposeguideapp.ui.theme.Typography

@Composable
fun GuideList(contentPadding: PaddingValues = PaddingValues(0.dp)) {
    LazyColumn(
        contentPadding = contentPadding
    ) {
        items(StepRepository.steps) {
            StepItem(it)
        }
    }
}

@Composable
private fun StepItem(
    step: Step,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        Column(
            modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(id = step.stepName),
                style = Typography.titleLarge
            )
            Image(
                painter = painterResource(id = step.stepImg),
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_small))
            )
            Text(
                text = stringResource(id = step.stepInfo),
                style = Typography.bodyMedium
            )
        }
    }
}

@Composable
@Preview (showBackground = true, showSystemUi = false)
private fun StepItemPreview() {
    StepItem(StepRepository.steps[0])
}