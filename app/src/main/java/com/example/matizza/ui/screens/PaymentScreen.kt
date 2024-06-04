package com.example.matizza.ui.screens

import android.location.Address
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.matizza.ui.theme.Green800

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
fun PaymentButton(onPayClick: () -> Unit = {}) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        colors = ButtonDefaults.buttonColors(Green800),
        onClick = { onPayClick() }) {
        Text(
            text = "Zapłać",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 25.sp
        )
    }
}

@Composable
fun PaymentTotalCost(totalAmount: String = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Koszt",
            color = Color.LightGray,
            fontWeight = FontWeight.Light,
            fontSize = 25.sp
        )
        Text(
            text = totalAmount,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
}

@Composable
fun PaymentAddress(address: String = "") {
    val placeIconn = ImageVector.vectorResource(id = R.drawable.ic_place)
    val editIcon = ImageBitmap.imageResource(id = R.drawable.ic_edit)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    imageVector = placeIconn,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Red)
                )
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Adres", fontWeight = FontWeight.Bold)
                    Text(text = address, fontWeight = FontWeight.Light)
                }
            }
        }

        IconButton(
            modifier = Modifier.border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10)
            ), onClick = { }) {
            Icon(
                modifier = Modifier.size(25.dp, 25.dp),
                bitmap = editIcon,
                contentDescription = null
            )
        }
    }
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
                contentDescription = null
            )
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
fun PaymentButtonPreview() {
    PaymentButton()
}

@Preview(showBackground = true)
@Composable
fun PaymentTotalCostPreview() {
    PaymentTotalCost(totalAmount = "32.60")
}

@Preview(showBackground = true)
@Composable
fun PaymentAddressPreview() {
    PaymentAddress(address = "Poniec, ul. Rynek 3")
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