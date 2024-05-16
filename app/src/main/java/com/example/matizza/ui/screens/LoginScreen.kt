package com.example.matizza.ui.screens

import android.graphics.drawable.Icon
import android.opengl.Visibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.IconButton
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
            text = email,
            textLabel = "Email",
            onValueChange = {str -> email = str}
        )

        PasswordTextFiled(
            password = password,
            textLabel = "Hasło",
            onValueChange = {str-> password = str}
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
            text = "Podaj adres email"
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = text,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(10),
            label = { Text(text = textLabel)},
            leadingIcon = {
                val emaiulIcon = Icons.Filled.Email
                Image(imageVector = emaiulIcon, contentDescription = null)
            }
        )
    }
}

@Composable
fun PasswordTextFiled(
    password: String,
    textLabel: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisable by rememberSaveable {
      mutableStateOf(false)
    }
    Column {
        Text(
            modifier = Modifier.padding( start = 16.dp),
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            text = "Podaj hasło"
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = password,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(10),
            label = { Text(text = textLabel)},
            visualTransformation =
                if(passwordVisable) VisualTransformation.None
                else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if(passwordVisable) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisable = !passwordVisable }) {
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