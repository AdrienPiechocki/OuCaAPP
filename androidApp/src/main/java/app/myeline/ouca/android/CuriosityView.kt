package app.myeline.ouca.android

import androidx.compose.foundation.layout.Column
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
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun CuriosityView(viewModel: CuriosityViewModel) {
    // var count by remember { mutableStateOf(0) }
    val curiosity by viewModel.curiosity.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        val curiosityLatLng = LatLng(curiosity.latitude, curiosity.longitude)
        Text(
            text = "Curiosity: $curiosity",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        GoogleMap(
            modifier = Modifier.height(200.dp),
            cameraPositionState = CameraPositionState(
                position = CameraPosition.fromLatLngZoom(curiosityLatLng, 10f)
            )
        ) {
            Marker(
                state = MarkerState(position = curiosityLatLng),
                title = curiosity.name,
                snippet = "Snippet"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.setCuriosity() },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Get curiosity")
        }
    }
}
