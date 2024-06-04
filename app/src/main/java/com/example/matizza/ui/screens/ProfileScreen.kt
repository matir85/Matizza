package com.example.matizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R
import com.example.matizza.data.UiState
import com.example.matizza.data.samples.sampleProfile

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
fun ProfileMenu() {

}

@Composable
fun ProfileHelp() {

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen(data = sampleProfile)
}