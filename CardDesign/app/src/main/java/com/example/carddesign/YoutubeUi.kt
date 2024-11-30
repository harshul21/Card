package com.example.carddesign

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carddesign.ui.theme.GreenJC

@Composable
fun YoutubeUi(youtubeData: YoutubeData)
{
    val context = LocalContext.current
    Card(onClick = {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XO8wew38VM8"))
        val chooser = Intent.createChooser(intent, "Open with")
        context.startActivity(chooser)
    },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {

        Column(
            Modifier.background(androidx.compose.ui.graphics.Color.White)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f)
            ){

                Image(painter = painterResource(id = youtubeData.thumbnail),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = "Play Button",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
                        .alpha(0.6f)
                )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f),
                ) {
                    Text(
                        text = "2:57",
                        color = androidx.compose.ui.graphics.Color.White ,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                            .alpha(0.9f)
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                Text(
                    text = youtubeData.videTitle,
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 18.sp
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = youtubeData.videoChannel,
                    maxLines = 1,
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 14.sp
                )

            }
        }
    }
}