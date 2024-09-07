package com.example.androidcomposeguideapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcomposeguideapp.model.Step
import com.example.androidcomposeguideapp.model.StepRepository
import com.example.androidcomposeguideapp.ui.theme.Shapes
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
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        Column(
            modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = step.stepName),
                    style = Typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                ExpandButton(
                    expanded = expanded,
                    onClick = {expanded = !expanded}
                )
            }

            if (expanded) {
                Image(
                    painter = painterResource(id = step.stepImg),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                        .height(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(Shapes.small)
                )
                Text(
                    text = stringResource(id = step.stepInfo),
                    style = Typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun ExpandButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
        )
    }
}

@Composable
@Preview (showBackground = true, showSystemUi = false)
private fun StepItemPreview() {
    StepItem(StepRepository.steps[0])
}