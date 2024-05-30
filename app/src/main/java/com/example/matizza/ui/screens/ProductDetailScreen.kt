package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.matizza.data.UiState
import com.example.matizza.data.samples.sampleItemDetailScreen
import com.example.matizza.ui.theme.Defoult50
import com.example.matizza.ui.theme.Green700
import com.example.matizza.ui.theme.Green800
import com.example.matizza.ui.theme.Neutral100


@Composable
fun ProductDetailScreen(
    data: UiState.ItemDetailScreen,
    onItemAdd: (ItemDetail) -> Unit = {},
    onGoToShoppingBag: () -> Unit = {}
) {
    // Zapamiętaj stan przewijania ekranu
    val scrollState = rememberScrollState()

    // Kolumna do rozmieszczenia elementów w pionie
    Column(
        modifier = Modifier
            .fillMaxSize() // Wypełnij cały rozmiar rodzica
            .verticalScroll(scrollState) // Włącz pionowe przewijanie
    ) {
        // Wyświetl nagłówek produktu
        ProductHeader()
        ProductImage(data.item.image)
        // Wyświetl szczegóły produktu
        ProductDetail(item = data.item, alreadyAdded = data.alreadyAdded)
    }
}

@Composable
fun ProductHashTag(name: String) {
    // Komponent Surface z wypełnieniem, cieniem, zaokrąglonymi rogami i kolorem tła
    Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(10),
        color = Defoult50
    ) {
        // Wyświetl tekst hashtagu z wypełnieniem i kolorem
        Text(
            modifier = Modifier.padding(7.dp),
            color = Green700,
            text = name
        )
    }
}

@Composable
fun ProductDetail(
    item: ItemDetail,
    alreadyAdded: Boolean = false,
    onItemAdd: (ItemDetail) -> Unit = {},
    onGoToShoppingBag: () -> Unit = {}
) {
    // Zapamiętaj stan, czy składniki i tabela kalorii są rozwinięte
    var isIngredientsExpandet by rememberSaveable {
        mutableStateOf(false)
    }
    var isCaloriesTableExpandet by rememberSaveable {
        mutableStateOf(false)
    }
    // Komponent Surface z wypełnieniem i zaokrąglonymi rogami
    Surface(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(10)
    ) {
        // Kolumna do rozmieszczenia elementów w pionie
        Column {
            // LazyRow do wyświetlania hashtagów w poziomie
            LazyRow {
                items(items = item.hashTags) { tag ->
                    ProductHashTag(name = tag)
                }
            }
            // Wiersz do wyświetlania nazwy produktu i ceny
            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    text = item.name
                )
                Text(
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = item.price.toString(),
                    textAlign = TextAlign.Center
                )
            }
            // Kolumna dla sekcji składników
            Column {
                // Wiersz z modyfikatorem klikalnym, aby przełączać rozwinięcie składników
                Row(
                    modifier = Modifier
                        .clickable { isIngredientsExpandet = !isIngredientsExpandet }
                        .padding(top = 45.dp)
                ) {
                    val ingredientsArrow = when (isIngredientsExpandet) {
                        true -> ImageVector.vectorResource(id = R.drawable.ic_arrow_down)
                        false -> ImageVector.vectorResource(id = R.drawable.ic_arrow_up)
                    }
                    Text(text = "Składniki")
                    Icon(imageVector = ingredientsArrow, contentDescription = null)
                }

                // Wyświetl tekst składników, jeśli rozwinięty
                if (isIngredientsExpandet) {
                    Text(
                        modifier = Modifier
                            .padding(top = 15.dp),
                        fontWeight = FontWeight.Bold,
                        text = item.ingredients
                    )
                }
            }
            // Kolumna dla sekcji tabeli kalorii
            Column {
                // Wiersz z modyfikatorem klikalnym, aby przełączać rozwinięcie tabeli kalorii
                Row(
                    modifier = Modifier
                        .clickable { isCaloriesTableExpandet = !isCaloriesTableExpandet }
                        .padding(top = 45.dp)
                ) {
                    val caloriesArrow = when (isCaloriesTableExpandet) {
                        true -> ImageVector.vectorResource(id = R.drawable.ic_arrow_down)
                        false -> ImageVector.vectorResource(id = R.drawable.ic_arrow_up)
                    }
                    Text(text = "Wartości odżywcze")
                    Icon(imageVector = caloriesArrow, contentDescription = null)
                }
                // Wyświetl tekst kalorii, jeśli rozwinięty
                if (isCaloriesTableExpandet) {
                    Text(
                        modifier = Modifier.padding(top = 15.dp),
                        fontWeight = FontWeight.Bold,
                        text = item.calories
                    )
                }
            }
            // Wyświetl przycisk do dodania do koszyka
            ShoppingBagButton(
                alreadyAdded = alreadyAdded,
                onClick = { onItemAdd(item) },
                onGoToShoppingBag = onGoToShoppingBag
            )
        }
    }
}

@Composable
fun ShoppingBagButton(
    alreadyAdded: Boolean,
    onClick: () -> Unit,
    onGoToShoppingBag: () -> Unit = {}
) {
    // Domyślny modyfikator dla przycisku
    val defaultModifier = Modifier
        .padding(vertical = 16.dp)
        .height(48.dp)
        .fillMaxWidth()
    // Pokaż różne przyciski w zależności od tego, czy produkt jest już dodany do koszyka
    when (alreadyAdded) {
        true -> {
            OutlinedButton(
                modifier = defaultModifier,
                onClick = onGoToShoppingBag,
                colors = ButtonDefaults.buttonColors(Green800)
            ) {
                // Box do wyrównania zawartości wewnątrz przycisku
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    // Wiersz do rozmieszczenia ikony i tekstu w poziomie
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            modifier = Modifier.size(24.dp, 24.dp),
                            bitmap = ImageBitmap.imageResource(id = R.drawable.ic_already_added),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = "Dpdano",
                            color = Color.White
                        )
                    }
                }

            }
        }

        false -> {
            OutlinedButton(
                modifier = defaultModifier,
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(Green800)
            ) {
                Text(text = "Dodaj do koszyka")
            }
        }
    }
}

@Composable
fun ProductImage(image: Int) {
    // Komponent Surface do wyświetlania obrazu produktu
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .size(350.dp, 350.dp)
    ) {
        // Komponent Image do wyświetlania obrazu
        Image(
            bitmap = ImageBitmap.imageResource(id = image),
            contentDescription = null,
            alignment = Alignment.Center
        )
    }
}

@Composable
fun ProductHeader() {
    // Wiersz do rozmieszczenia elementów w poziomie
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Ikona powrotu
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_left),
            contentDescription = null
        )
        // Ikona ulubionych
        Icon(
            modifier = Modifier
                .size(35.dp, 35.dp)
                .clip(CircleShape)
                .background(Neutral100),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_favourite_border),
            contentDescription = null
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProductDetailScreenView() {
    ProductDetailScreen(sampleItemDetailScreen)
}

