package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R

@Composable
fun PaymentScreen(modifier: Modifier = Modifier) {
    Column {
        PaymentHeadder()
        PaymentCardDetail()
        PaymentAddress()
        PaymentTotalCost()
        PaymentButton()
    }
}

@Composable
fun PaymentButton() {

}

@Composable
fun PaymentTotalCost() {

}

@Composable
fun PaymentAddress() {

}

@Composable
fun PaymentCardDetail() {

}

@Composable
fun PaymentHeadder(onClose: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 20.dp),
            text = "Płatnośc",
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier.clickable { onClose() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(10.dp, 10.dp),
                bitmap = ImageBitmap.imageResource(id = R.drawable.ic_close),
                contentDescription = null
            )
        }
    }
}
