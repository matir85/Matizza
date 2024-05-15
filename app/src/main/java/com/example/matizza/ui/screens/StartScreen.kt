package com.example.matizza.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.matizza.R

@Composable
fun StartScreen(modifier: Modifier = Modifier) {
    // zmienna na zdjęcie
    val image = ImageBitmap.imageResource(id = R.drawable.start_screen_background)

    // wyświetlenie zdjęcia na ekranie
    Image(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        bitmap = image,
        contentDescription = null,
        // dopasowanie - do szerokości okna
        contentScale = ContentScale.Crop,
        // przyciemnienie
        alpha = 0.5f
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            modifier = Modifier.align(CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            text = "Matizza"
        )
        Text(
            modifier = Modifier.padding(),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            color = Color.White,
            text = "Pizza domowa"
        )
        OutlinedButton(onClick = { /*TODO*/ }) {

        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun StartScrenPreview() {
    StartScreen()
}