package app.myeline.ouca.android

import android.widget.Toast
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
fun CuriosityDetail(viewModel: CuriosityViewModel) {
    val curiosity by viewModel.curiosity.collectAsState()
    val name = curiosity.name
    val category = curiosity.category
    val latitude = curiosity.latitude
    val longitude = curiosity.longitude

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Curiosity: $name \n" +
                    "Category: $category \n" +
                    "Coordinates: $latitude, $longitude",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {  },
            modifier = Modifier.width(100.dp)
        ) {
            Text(text = "Back")
        }

    }
}