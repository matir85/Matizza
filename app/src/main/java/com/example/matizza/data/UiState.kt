package com.example.matizza.data

sealed class UiState {
    data class Home(
        val product: List<ItemsDetail>,
        val userData: UserData
    )
    data class Profile(
        val name: String,
        val surname: String,
        val email: String
    )
    data class ShoppingBag(
        val itemList: List<Order>
    )
    data class OrderHistory(
        val orderList: List<Order>
    )
    data class ItemDetailScreen(
        val item: ItemsDetail,
        val alreadyAdded: Boolean = false
    )
    data class Payment(
        val userDAta: UserData,
        val orderList: List<Order>
    )
    data class Map(
        val name: String,
        val surname: String
    )
}
