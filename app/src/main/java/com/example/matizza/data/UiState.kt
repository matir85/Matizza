package com.example.matizza.data

// Deklaracja klasy sealed UiState, która reprezentuje różne stany interfejsu użytkownika
sealed class UiState {
    // Stan Home zawierający listę produktów oraz dane użytkownika
    data class Home(
        val products: List<ItemDetail>, // Lista produktów
        val userData: UserData // Dane użytkownika
    )
    // Stan Profile zawierający dane profilu użytkownika
    data class Profile(
        val name: String, // Imię użytkownika
        val surname: String, // Nazwisko użytkownika
        val email: String // Adres e-mail użytkownika
    )
    // Stan ShoppingBag zawierający listę zamówionych przedmiotów
    data class ShoppingBag(
        val itemList: List<Order> // Lista zamówionych przedmiotów
    )
    // Stan OrderHistory zawierający historię zamówień
    data class OrderHistory(
        val orderList: List<Order> // Lista zrealizowanych zamówień
    )
    // Stan ItemDetailScreen zawierający szczegóły wybranego przedmiotu
    data class ItemDetailScreen(
        val item: ItemDetail, // Szczegóły przedmiotu
        val alreadyAdded: Boolean = false // Flaga oznaczająca, czy przedmiot został już dodany do koszyka
    )
    // Stan Payment zawierający dane użytkownika oraz listę zamówionych przedmiotów do płatności
    data class Payment(
        val userData: UserData, // Dane użytkownika
        val orderList: List<Order> // Lista zamówionych przedmiotów
    )
    // Stan Map zawierający dane do wyświetlenia trasy na mapie
    data class Map(
        val name: String, // Imię użytkownika
        val surname: String, // Nazwisko użytkownika
        val sourceAddress: String, // Adres źródłowy
        val targetAddress: String // Adres docelowy
    )
}

/* Wszystkie powyższe dane klas w UiState reprezentują różne stany aplikacji,
które mogą być używane do przechowywania i zarządzania stanem interfejsu użytkownika w aplikacji.
Każda z tych klas zawiera odpowiednie dane specyficzne dla danego stanu. */