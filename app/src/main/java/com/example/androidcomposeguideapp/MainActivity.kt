package com.example.androidcomposeguideapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidcomposeguideapp.ui.theme.AndroidComposeGuideAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeGuideAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GuideApp()
                }
            }
        }
    }
}

@Composable
private fun GuideApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() }
    ) {
        GuideList(contentPadding = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        },
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingDarkPreview() {
    AndroidComposeGuideAppTheme(darkTheme = true) {
        GuideApp()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingLightPreview() {
    AndroidComposeGuideAppTheme(darkTheme = false) {
        GuideApp()
    }
}