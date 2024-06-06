package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R
import com.example.matizza.data.Order
import com.example.matizza.data.UiState
import com.example.matizza.data.samples.sampleEmptyOrderHistoryData
import com.example.matizza.ui.theme.Green800

@Composable
fun OrderHistoryScreen(
    modifier: Modifier = Modifier,
    data: UiState.OrderHistory,
    onEmptyHistoryClick: () -> Unit = {}
) {
    when (data.orderList.isEmpty()) {
        true -> EmptyOrderHistory(onEmptyHistoryClick)
        false -> OrderHistory(data.orderList)
    }
}

@Composable
fun OrderHistory(orderList: List<Order>) {

}

@Composable
fun EmptyOrderHistory(onEmptyHistoryClick: () -> Unit) {
    val emptyHistoryImage = ImageBitmap.imageResource(id = R.drawable.empty_order_history)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(200.dp, 200.dp),
            bitmap = emptyHistoryImage,
            contentDescription = null
        )
        Text(
            text = "Nie masz jeszcze\n żadnych zamówień",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "Złóż pierwsze zamówienie, aby sprawdzić\n jego szczegóły",
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(Green800),
            onClick = onEmptyHistoryClick,
            shape = RoundedCornerShape(20)
        ) {
            Text(text = "Zacznij zamówienie", color = Color.White)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmptyOrderHistoryPreview() {
    OrderHistoryScreen(data = sampleEmptyOrderHistoryData)
}