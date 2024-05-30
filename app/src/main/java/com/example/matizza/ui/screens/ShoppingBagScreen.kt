package com.example.matizza.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShoppingBagScreen(modifier: Modifier = Modifier) {
    Column {
        Box(modifier = Modifier.padding(start = 16.dp, top = 25.dp)){
            Text(
                text = "Koszyk",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
        ShoppingBagList()
        SumUP()
    }
}

@Composable
fun SumUP() {

}

@Composable
fun ShoppingBagList() {

}
