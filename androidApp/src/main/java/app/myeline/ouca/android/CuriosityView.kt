package app.myeline.ouca.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.myeline.ouca.CuriosityViewModel
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun CuriosityView(viewModel: CuriosityViewModel) {
    // var count by remember { mutableStateOf(0) }
    val curiosity by viewModel.curiosity.collectAsState()
    val name = curiosity.name
    val category = curiosity.category
    val latitude = curiosity.latitude
    val longitude = curiosity.longitude

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        val curiosityLatLng = LatLng(latitude, longitude)
        val cameraPositionState = CameraPositionState (
            position = CameraPosition.fromLatLngZoom(curiosityLatLng, 10f)
        )

        Text(
            text = "Curiosity: $name is $category at $curiosityLatLng",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        GoogleMap(
            modifier = Modifier.height(400.dp),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = curiosityLatLng),
                title = curiosity.name,
                snippet = "Snippet"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Button(
                onClick = { viewModel.previousCuriosity() },
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { viewModel.nextCuriosity() },
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Next")
            }
        }
        Button(
            onClick = { cameraPositionState.position = CameraPosition.fromLatLngZoom(curiosityLatLng, 10f) },
            modifier = Modifier.width(100.dp)
        ) {
            Text(text = "Center")
        }

    }
}