package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtScreenPreview(modifier = Modifier.fillMaxSize())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtScreenPreview(modifier: Modifier = Modifier) {
    ArtSpaceTheme {
        ArtScreen(modifier)
    }
}

@Composable
fun ArtScreen(modifier: Modifier = Modifier) {

    var photoId = R.drawable.a1
    var titleId = R.string.title1
    var locationId = R.string.location1
    var photographerId = R.string.artist1

    var picId by remember { mutableStateOf(1) }
    val totalImage = 8

    when(picId) {
        1 -> {
            photoId = R.drawable.a1
            titleId = R.string.title1
            locationId = R.string.location1
            photographerId = R.string.artist1
        }
        2 -> {
            photoId = R.drawable.a2
            titleId = R.string.title2
            locationId = R.string.location2
            photographerId = R.string.artist2
        }
        3 -> {
            photoId = R.drawable.a3
            titleId = R.string.title3
            locationId = R.string.location3
            photographerId = R.string.artist3
        }
        4 -> {
            photoId = R.drawable.a4
            titleId = R.string.title4
            locationId = R.string.location4
            photographerId = R.string.artist4
        }
        5 -> {
            photoId = R.drawable.a5
            titleId = R.string.title5
            locationId = R.string.location5
            photographerId = R.string.artist5
        }
        6 -> {
            photoId = R.drawable.a6
            titleId = R.string.title6
            locationId = R.string.location6
            photographerId = R.string.artist6
        }
        7 -> {
            photoId = R.drawable.a7
            titleId = R.string.title7
            locationId = R.string.location7
            photographerId = R.string.artist7
        }
        8 -> {
            photoId = R.drawable.a8
            titleId = R.string.title8
            locationId = R.string.location8
            photographerId = R.string.artist8
        }
    }

    val photo = painterResource(id = photoId)
    val photoTitle = stringResource(id = titleId)
    val photoLocation = stringResource(id = locationId)
    val photographer = stringResource(id = photographerId)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = photo,
            contentDescription = photoTitle,
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 32.dp)
                .border(width = 1.dp, color = Color.Black)
                .border(width = 16.dp, color = Color.White)
        )

        Spacer(Modifier.height(16.dp))

        Column(modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = photoTitle,
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            Row() {
                Text(
                    text = "$photographer ("
                )
                Text(
                    text = "$photoLocation",
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = ")"
                )
            }
        }

        Row(
            modifier = modifier
                .wrapContentHeight(Alignment.Bottom)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(bottom = 64.dp)
        ) {
            Button(
                onClick = { picId = prevSeq(picId, totalImage)}
            ) {
                Text(text = stringResource(id = R.string.button_previous))
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = { picId = nextSeq(picId, totalImage)},
                modifier = Modifier
            ) {
                Text(text = stringResource(id = R.string.button_next))
            }
        }


    }
}

private fun prevSeq(picId: Int, totalImage: Int = 1): Int{
    return if(picId==1) totalImage else picId-1
}
private fun nextSeq(picId: Int, totalImage: Int = 1): Int{
    return if(picId==totalImage) 1 else picId+1
}