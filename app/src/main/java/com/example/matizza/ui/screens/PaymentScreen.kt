package com.example.matizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
fun PaymentHeadder() {

}
