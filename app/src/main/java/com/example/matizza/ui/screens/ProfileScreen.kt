package com.example.matizza.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.matizza.data.UiState
import com.example.matizza.data.samples.sampleProfile
import com.example.matizza.ui.theme.Green800

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
fun ProfileHelp() {

}

@Composable
fun ProfileMenu() {
    Column {
        ProfileButton(
            resourceId = R.drawable.ic_history,
            buttonText = "Historia",
            onClick = {}
        )
        ProfileButton(
            resourceId = R.drawable.ic_profile,
            buttonText = "Profil",
            onClick = {}
        )
        ProfileButton(
            resourceId = R.drawable.ic_address,
            buttonText = "Adres",
            onClick = {}
        )
        ProfileButton(
            resourceId = R.drawable.ic_payments,
            buttonText = "Płatność",
            onClick = {}
        )
    }
}

@Composable
fun ProfileHeader() {
    val arrowLeft = ImageVector.vectorResource(id = R.drawable.ic_arrow_left)

    Row(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = arrowLeft, contentDescription = null)
        Text(text = "Profil", fontWeight = FontWeight.Bold, fontSize = 22.sp)
    }
}

@Composable
fun ProfileButton(
    @DrawableRes resourceId: Int,
    buttonText: String,
    onClick: () -> Unit
) {
    val arroeRight = ImageVector.vectorResource(id = R.drawable.ic_arrow_right)
    val displayIcon = ImageBitmap.imageResource(id = resourceId)

    OutlinedButton(
        modifier = Modifier.padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        onClick = onClick,
        shape = RoundedCornerShape(10)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .padding(end = 10.dp),
                bitmap = displayIcon,
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = buttonText,
                textAlign = TextAlign.Start,
                color = Color.Black)
            Image(
                imageVector = arroeRight,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Green800)
            )
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(data = sampleProfile)
}