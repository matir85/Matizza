package com.example.matizza.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matizza.R
import com.example.matizza.data.UiState
import com.example.matizza.data.samples.sampleMapData
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
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                text = "Twoje zamówienie",
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            OrderMap()
        }
        AnimatedVisibility(
            visible = isDetailVisable,
            enter = slideIn { IntOffset(0, 500) } + fadeIn(),
            exit = slideOut{IntOffset(0,500)} + fadeOut()
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter) {
                InfoCard(
                    name = data.name,
                    surname = data.surname,
                    sourceAddress = data.sourceAddress,
                    targetAddress = data.targetAddress
                )
            }
        }
        Box(contentAlignment = Alignment.BottomCenter) {
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(Green800),
                shape = RoundedCornerShape(20),
                onClick = { isDetailVisable = !isDetailVisable }
            ) {
                if (isDetailVisable) Text(text = "Ukryj szczegóły", color = Color.White)
                else Text(text = "Zobacz szczegóły", color = Color.White)
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
                        modifier = Modifier.border(
                            1.dp,
                            color = Color.LightGray,
                            shape = CircleShape
                        ),
                        onClick = { }) {
                        val editIcon = ImageBitmap.imageResource(id = R.drawable.ic_phone)
                        Icon(
                            modifier = Modifier.size(25.dp, 25.dp),
                            bitmap = editIcon, contentDescription = null,
                            tint = Green800
                        )
                    }
                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 30.dp)
                    .offset(y = -20.dp),
                shape = RoundedCornerShape(12),
                shadowElevation = 1.dp
            ) {
                val placeIcon = ImageBitmap.imageResource(id = R.drawable.ic_address)
                val clockImage = ImageBitmap.imageResource(id = R.drawable.ic_clock)

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoCardRow(
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                        bitmap = placeIcon,
                        address = sourceAddress
                    )
                    Image(
                        modifier = Modifier
                            .padding(start = 25.dp)
                            .size(30.dp, 70.dp),
                        bitmap = ImageBitmap.imageResource(id = R.drawable.ic_line),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.LightGray)
                    )
                    InfoCardRow(
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                        bitmap = clockImage,
                        address = targetAddress
                    )
                }
            }
        }
    }
}

@Composable
fun InfoCardRow(
    modifier: Modifier = Modifier,
    bitmap: ImageBitmap,
    address: String
) {
    Row(modifier = modifier) {
        IconButton(
            modifier = Modifier.border(1.dp, color = Color.LightGray, shape = CircleShape),
            onClick = { }) {
            Icon(
                modifier = Modifier.size(25.dp, 25.dp),
                tint = Green800,
                bitmap = bitmap,
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = address,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MapScreenPreview() {
    MapScreen(data = sampleMapData)
}