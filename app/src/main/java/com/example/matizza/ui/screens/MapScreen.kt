package com.example.matizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R

import com.example.matizza.data.UiState
import com.example.matizza.ui.theme.Defoult50
import com.example.matizza.ui.theme.Green800
import com.example.matizza.ui.theme.Neutral900
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    data: UiState.Map
) {
    var isDetailVisable by remember {
        mutableStateOf(true)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = "Twoje zamówienie",
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            OrderMap()
        }
        Box(modifier = Modifier) {
            InfoCard()
        }
        Box {
            OutlinedButton(onClick = { /*TODO*/ }) {

            }
        }
    }
}

@Composable
fun InfoCard(
    name: String = "",
    surname: String = "",
    sourceAddress: String = "",
    targetAddress: String = ""
) {
    val profileImage = ImageBitmap.imageResource(id = R.drawable.profile_image)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp),
        color = Neutral900
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .size(60.dp, 60.dp)
                        .padding(end = 16.dp),
                    bitmap = profileImage,
                    contentDescription = null
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "$name $surname", fontWeight = FontWeight.Bold, color = Color.White)
                    Text(text = "555-487-898", fontWeight = FontWeight.Light, color = Color.White)
                }
                Surface(shape = CircleShape, color = Defoult50) {
                    IconButton(
                        modifier = Modifier.border(1.dp, color = Color.LightGray, shape = CircleShape),
                        onClick = {  }) {
                        val editIcon = ImageBitmap.imageResource(id = R.drawable.ic_phone)
                        Icon(
                            modifier = Modifier.size(25.dp, 25.dp),
                            bitmap = editIcon, contentDescription = null,
                            tint = Green800)
                    }
                }
            }
        }
    }
}

@Composable
fun OrderMap(modifier: Modifier = Modifier) {
    var startPlace = LatLng(51.765165, 16.805898)
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(startPlace, 10f)
    }
    Surface(
        modifier = modifier.fillMaxSize(),
        shadowElevation = 1.dp
    ) {
        GoogleMap(
            modifier = modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(state = MarkerState(startPlace), title = "Poniec", snippet = "Marker in Poniec")
        }
    }
}
