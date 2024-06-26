package com.example.matizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.matizza.ui.screens.StartScreen
import com.example.matizza.ui.theme.MatizzaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatizzaTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    StartScreen(onStartClick = {
                        // nawiguj do ekranu logowania
                    })
                }
            }
        }
    }
}
