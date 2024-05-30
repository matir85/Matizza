package com.example.matizza.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.matizza.data.ItemDetail
import com.example.matizza.data.Order
import com.example.matizza.data.samples.sampleShoppingBag
import com.example.matizza.ui.theme.Green800

@Composable
fun ShoppingBagScreen(
    shopingList: List<Order>,
    onIncrementOrderNumber: (ItemDetail) -> Unit = {},
    onDecrementOrderNumber: (ItemDetail) -> Unit = {}
) {
    Column {
        Box(modifier = Modifier.padding(start = 16.dp, top = 25.dp)) {
            Text(
                text = "Koszyk",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
        ShoppingBagList(shopingList, onIncrementOrderNumber, onDecrementOrderNumber)
        SumUp()
    }
}

@Composable
fun SumUp() {

}

@Composable
fun ShoppingBagList(
    shopingList: List<Order>,
    onIncrementOrderNumber: (ItemDetail) -> Unit,
    onDecrementOrderNumber: (ItemDetail) -> Unit
) {
    LazyColumn {
        items(items = shopingList) { order ->
            ShoppingBagItem(
                order = order,
                onIncrementOrderNumber = onIncrementOrderNumber,
                onDecrementOrderNumber = onDecrementOrderNumber
            )
        }
    }
}

@Composable
fun ShoppingBagItem(
    order: Order,
    onIncrementOrderNumber: (ItemDetail) -> Unit = {},
    onDecrementOrderNumber: (ItemDetail) -> Unit = {}
) {
    val pizzaImage: ImageBitmap = ImageBitmap.imageResource(id = order.item.image)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(20)
    ) {
        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier.size(125.dp, 125.dp),
                    bitmap = pizzaImage, contentDescription = null
                )
                Column {
                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(bottom = 10.dp),
                        text = order.item.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        val addIcon = ImageVector.vectorResource(id = R.drawable.ic_add)
                        val minusIcon = ImageBitmap.imageResource(id = R.drawable.ic_minus)
                        IconButton(

                            modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, color = Color.LightGray),
                                    shape = RoundedCornerShape(20)
                                ),
                            onClick = { onDecrementOrderNumber(order.item) },
                        ) {
                            Icon(bitmap = minusIcon, contentDescription = null, tint = Green800)
                        }
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 20.dp),
                            text = order.count.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        IconButton(
                            modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, color = Color.LightGray),
                                    shape = RoundedCornerShape(20)
                                ),
                            onClick = { onIncrementOrderNumber(order.item) }
                        ) {
                            Icon(imageVector = addIcon, contentDescription = null, tint = Green800)
                        }
                    }
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = order.item.price.toString(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShoppingBagScreenPreview() {
    ShoppingBagScreen(shopingList = sampleShoppingBag.itemList)
}

@Preview(showBackground = true)
@Composable
fun ShoppingBagItemPreview() {
    ShoppingBagItem(order =  sampleShoppingBag.itemList[0])
}