package com.example.androidcomposeguideapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = Modifier.fillMaxSize()
    ) {
        GuideList(contentPadding = it)
    }
}

@Composable
private fun GuideList(contentPadding: PaddingValues = PaddingValues(0.dp)) {
    Text(
        text = "Hello!"
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    AndroidComposeGuideAppTheme {
        GuideApp()
    }
}