package com.example.matizza.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.matizza.R
import com.example.matizza.ui.theme.Green800

@Composable
fun StartScreen(onStartClick: () -> Unit = {}) {
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
            modifier = Modifier.padding(bottom = 100.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            color = Color.White,
            text = "Pizza domowa"
        )
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 100.dp)
                .height(48.dp),
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(Green800),
            onClick = { onStartClick() }
        ) {
            // zmienna zawierająca wektor strzałki w prawo
            val iconArrow = ImageVector.vectorResource(id = R.drawable.ic_arrow_right)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                color = Color.White,
                text = "Zaloguj się"
            )
            Icon(
                modifier = Modifier.padding(start = 10.dp),
                imageVector = iconArrow,
                contentDescription = null,
                tint = Color.White
            )
        }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun StartScrenPreview() {
    StartScreen()
}