package com.example.matizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductDetailScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
ProductHeader()
        ProductImage()
        ProductDetail()
    }
}

@Composable
fun ProductDetail() {
    TODO("Not yet implemented")
}

@Composable
fun ProductImage() {
    TODO("Not yet implemented")
}

@Composable
fun ProductHeader() {
    TODO("Not yet implemented")
}
