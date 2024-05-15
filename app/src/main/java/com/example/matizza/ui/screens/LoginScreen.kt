package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R

@Composable
fun LoginScreen(
    // podajemy zachowania, które chcemy obsłużyć
    onClickLogin: (String, String) -> Unit,
    onClickGoogle: () -> Unit
) {
    // zmienne do przetrzymywania wpisanego tekstu
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // uchwyt do ikonki - loga
        val imageBitmap = ImageBitmap.imageResource(id = R.drawable.login_logo)
        // wyświetlenie loga
        Image(
            modifier = Modifier.sizeIn(minWidth = 100.dp, minHeight = 100.dp),
            bitmap = imageBitmap,
            contentDescription = null)
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            text = "Zaloguj się do\n swojego konta"
        )
        // Wywołanie pola do wpisania adresu emaiul
        EmailTextFiled(
            text = "Email",
            textLabel = "Wpisz adres email",
            onValueChange = {str -> email = str}
        )
    }
}

// Pole do wpisania adresu email
@Composable
fun EmailTextFiled(
    text: String,
    textLabel: String,
    onValueChange: (String) -> Unit
    ) {
    Column {
        Text(
            modifier = Modifier.padding( start = 16.dp),
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            text = text
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(10),
            value = textLabel,
            onValueChange = onValueChange
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onClickLogin = { s1, s2 -> }) {}
}