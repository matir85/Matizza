package com.example.matizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.matizza.data.UiState

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    data: UiState.Profile,
    onHistoryClick: () -> Unit = {},
    onProfileDataClick: () -> Unit = {},
    onAddressClick: () -> Unit = {},
    onPaymentClick: () -> Unit = {}
) {
    Column {
        ProfileHeader()
        ProfileMenu()
        ProfileHelp()
    }
}

@Composable
fun ProfileHeader() {
    TODO("Not yet implemented")
}

@Composable
fun ProfileMenu() {
    TODO("Not yet implemented")
}

@Composable
fun ProfileHelp() {
    TODO("Not yet implemented")
}
