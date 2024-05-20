package com.example.matizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
//    data:
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSearch: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 2.dp, end = 2.dp, bottom = 10.dp)
    ) {
        HomeHeder()
        WelcomeText()
        SearchFild()
        PromotionAds()
        OfferList()
    }

}

@Composable
fun OfferList() {
    TODO("Not yet implemented")
}

@Composable
fun PromotionAds() {
    TODO("Not yet implemented")
}

@Composable
fun SearchFild() {
    TODO("Not yet implemented")
}

@Composable
fun WelcomeText() {
    TODO("Not yet implemented")
}

@Composable
fun HomeHeder() {
    TODO("Not yet implemented")
}
