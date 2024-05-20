package com.example.matizza.ui.screens

import android.graphics.drawable.Icon
import android.opengl.Visibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R
import com.example.matizza.ui.theme.Green800

@Composable
fun LoginScreen(
    // podajemy zachowania, które chcemy obsłużyć
    onClickLogin: (String, String) -> Unit, // Funkcja wywoływana po kliknięciu przycisku logowania z parametrami email i hasło
    onClickGoogle: () -> Unit // Funkcja wywoływana po kliknięciu przycisku logowania za pomocą Google
) {
    // zmienne do przetrzymywania wpisanego tekstu
    var email by remember {
        mutableStateOf("")  // Zmienna przechowująca adres email
    }
    var password by remember {
        mutableStateOf("")  // Zmienna przechowująca hasło
    }

    Column(   // Layout kolumny wypełniającej cały ekran
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // uchwyt do ikonki - loga
        val imageBitmap = ImageBitmap.imageResource(id = R.drawable.login_logo)
        // wyświetlenie loga
        Image(
            modifier = Modifier.sizeIn(minWidth = 60.dp, minHeight = 60.dp),
            bitmap = imageBitmap,
            contentDescription = null
        )
        // Tekst nagłówkowy ekranu logowania
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            text = "Zaloguj się do\n swojego konta"
        )
        // Wywołanie pola do wpisania adresu email
        EmailTextFiled(
            text = email,
            textLabel = "Email",
            onValueChange = { str -> email = str } // Aktualizacja zmiennej email przy zmianie tekstu
        )

        // Wywołanie pola do wpisania hasła
        PasswordTextFiled(
            password = password,
            textLabel = "Hasło",
            onValueChange = { str -> password = str } // Aktualizacja zmiennej password przy zmianie tekstu
        )

        // Tekst z odnośnikiem do resetowania hasła
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 16.dp, bottom = 16.dp),
                fontWeight = FontWeight.SemiBold,
                color = Green800,
                text = "Zapomniałeś hasła?"
            )
        }

        // Przycisk logowania
        OutlinedButton(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(Green800),
            onClick = { onClickLogin(email, password) } // Wywołanie funkcji logowania po kliknięciu
        ) {
            Text(
                text = "Zaloguj się",  // Tekst na przycisku logowania
                color = Color.White
            )
        }

        // Przycisk logowania za pomocą Google
        OutlinedButton(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .height(48.dp)
                .fillMaxWidth(),
            onClick = { onClickGoogle } // Wywołanie funkcji logowania za pomocą Google po kliknięciu
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ikona Google
                androidx.compose.material3.Icon(
                    modifier = Modifier
                        .size(25.dp, 25.dp)
                        .padding(end = 5.dp),
                    bitmap = ImageBitmap.imageResource(id = R.drawable.ic_google),
                    contentDescription = null)
                // Tekst na przycisku logowania za pomocą Google
                Text(
                    text = "Zaloguj się za pomocą Google",
                    color = Color.Black
                )
            }
        }

        // Tekst z odnośnikiem do rejestracji
        Box(modifier = Modifier
            .padding(top = 30.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row {
                Text(text = "Nie masz konta ?")
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    color = Green800,
                    fontWeight = FontWeight.SemiBold,
                    text = "Rejestracja"
                )
            }
        }

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
        // Tekst pomocniczy nad polem email
        Text(
            modifier = Modifier.padding(start = 16.dp),
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            text = "Podaj adres email"
        )
        // Pole tekstowe do wpisania adresu email
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = text, // Aktualny tekst w polu email
            onValueChange = onValueChange, // Funkcja wywoływana przy zmianie tekstu
            shape = RoundedCornerShape(10), // Zaokrąglone rogi pola tekstowego
            label = { Text(text = textLabel) }, // Etykieta pola tekstowego
            leadingIcon = {
                val emaiulIcon = Icons.Filled.Email
                Image(imageVector = emaiulIcon, contentDescription = null) // Ikona email przed polem tekstowym
            }
        )
    }
}
// Pole do wpisania hasła
@Composable
fun PasswordTextFiled(
    password: String,
    textLabel: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisable by rememberSaveable {
        mutableStateOf(false) // Zmienna określająca widoczność hasła
    }
    Column {
        // Tekst pomocniczy nad polem hasła
        Text(
            modifier = Modifier.padding(start = 16.dp),
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            text = "Podaj hasło"
        )
        // Pole tekstowe do wpisania hasła
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = password, // Aktualne hasło w polu tekstowym
            onValueChange = onValueChange, // Funkcja wywoływana przy zmianie hasła
            shape = RoundedCornerShape(10), // Zaokrąglone rogi pola tekstowego
            label = { Text(text = textLabel) }, // Etykieta pola tekstowego
            visualTransformation =
            if (passwordVisable) VisualTransformation.None // Widoczność hasła
            else PasswordVisualTransformation(), // Ukrywanie hasła
            trailingIcon = {
                val image = if (passwordVisable) Icons.Filled.Visibility // Ikona widoczności hasła
                else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisable = !passwordVisable }) { // Przycisk zmiany widoczności hasła
                    Image(imageVector = image, contentDescription = null)
                }
            }

        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_8", apiLevel = 34)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onClickLogin = { s1, s2 -> }) {}
}