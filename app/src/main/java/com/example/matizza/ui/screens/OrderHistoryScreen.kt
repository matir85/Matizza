package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R
import com.example.matizza.data.Order
import com.example.matizza.data.UiState
import com.example.matizza.data.samples.sampleEmptyOrderHistoryData
import com.example.matizza.data.samples.sampleOrderHistoryData
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
    Column {
        OrdersHistoryHeader(orderNumber = orderList.size)
        LazyColumn(contentPadding = PaddingValues(bottom = 100.dp)) {
            items(items = orderList,
                key = { order: Order -> order.item.id }) { order ->
                OrderHistoryItem(order)
            }
        }
    }
}

@Composable
fun OrderHistoryItem(order: Order) {
    Surface(
        modifier = Modifier
            .wrapContentWidth()
            .padding(10.dp),
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(10)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 2.dp),
                text = "${order.item.orderState}, ${order.item.date}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "${order.item.name}...",
                fontWeight = FontWeight.Light
            )
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = (order.item.price * order.count).toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Green800
                    )
                    val arrowRights = ImageVector.vectorResource(id = R.drawable.ic_arrow_right)
                    Icon(imageVector = arrowRights, contentDescription = null, tint = Green800)
                }
            }
        }
    }
}

@Composable
fun OrdersHistoryHeader(orderNumber: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "Historia zamówień ($orderNumber)",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OrderHistoryPreview() {
    OrderHistoryScreen(data = sampleOrderHistoryData)
}