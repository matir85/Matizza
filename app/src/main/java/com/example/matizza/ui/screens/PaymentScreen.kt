package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    Surface(
        modifier = Modifier
            .wrapContentWidth()
            .padding(horizontal = 16.dp),
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(10)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 16.dp)
                    .size(35.dp, 35.dp),
                bitmap = ImageBitmap.imageResource(id = R.drawable.ic_visa_logo),
                contentDescription = null)
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = " **** **** 2569")
                Text(text = "Metoda płatności")
            }
        }
    }
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
            text = "Płatność",
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
                    .size(15.dp, 15.dp),
                bitmap = ImageBitmap.imageResource(id = R.drawable.ic_close),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentCadrDetailPreview() {
    PaymentCardDetail()
}

@Preview(showBackground = true)
@Composable
fun PaymentHeaderPreview() {
    PaymentHeadder()
}