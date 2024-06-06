package com.example.matizza.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.matizza.data.UiState

@Composable
fun OrderHistoryScreen(
    modifier: Modifier = Modifier,
    data: UiState.OrderHistory,
    onEmptyHistoryClick: () -> Unit = {}
) {
    when(data.orderList.isEmpty()) {
        true -> EmptyOrderHistory(onEmptyHistoryClick)
        false -> OrderHistory(data.orderList)
    }
}