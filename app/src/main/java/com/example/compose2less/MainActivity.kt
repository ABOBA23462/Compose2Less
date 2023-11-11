package com.example.compose2less

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose2less.ui.theme.Blue
import com.example.compose2less.ui.theme.Compose2LessTheme
import com.example.compose2less.ui.theme.Gray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose2LessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun BaseImage(modifier: Modifier = Modifier, image: Int) {
    Image(
        modifier = modifier,
        painter = painterResource(image),
        contentDescription = "base image",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun BaseText(modifier: Modifier = Modifier, textSize: Int, text: String, textColor: Color) {
    Text(modifier = modifier, text = text, fontSize = textSize.sp, color = textColor)
}

@Composable
fun BaseELement(modifier: Modifier = Modifier, image: Int, text_1: String, text_2: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        BaseImage(modifier = Modifier.size(24.dp), image = image)
        Spacer(modifier = Modifier.height(20.dp))
        BaseText(textSize = 16, text = text_1, textColor = Color.Black)
        BaseText(textSize = 8, text = text_2, textColor = Color.Gray)
    }
}

@Composable
fun BaseCardWithElements(
    modifier: Modifier = Modifier,
    image: Int,
    text_1: String,
    text_2: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Box(modifier = Modifier.size(100.dp)) {
            BaseELement(
                modifier = Modifier.align(Alignment.Center),
                image = image,
                text_1 = text_1,
                text_2 = text_2
            )
        }
    }
}
@Composable
@Preview(showBackground = true)
fun BaseColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(Color.White, RoundedCornerShape(20.dp)),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BaseText(
                modifier = Modifier.padding(start = 10.dp),
                textSize = 14,
                text = "Sunday, 19 May 2019 | 4:30PM",
                textColor = Color.Gray
            )
            Button(
                onClick = { Log.e(TAG, "BaseColumn: hello") },
                colors = ButtonDefaults.buttonColors(
                    Gray
                ),
                shape = RoundedCornerShape(bottomStart = 20.dp)
            ) {
                BaseText(textSize = 16, text = "Mumbai, India", textColor = Blue)
                BaseImage(image = R.drawable.facebook_places)
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 26.dp, start = 26.dp, end = 26.dp)
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterStart),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BaseImage(modifier = Modifier.size(40.dp), image = R.drawable.ic_sunny)
                BaseText(textSize = 18, text = "Sunny", textColor = Color.Black)
            }
            Row(modifier = Modifier.align(Alignment.TopCenter)) {
                BaseText(textSize = 64, text = "33", textColor = Color.Black)
                BaseText(
                    modifier = Modifier.padding(top = 20.dp),
                    textSize = 24,
                    text = "°C",
                    textColor = Color.Black
                )
            }
            Column(
                modifier = Modifier.align(Alignment.CenterEnd),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BaseText(textSize = 16, text = "35°C↑", textColor = Color.Gray)
                BaseText(textSize = 16, text = "27°C↓", textColor = Color.Gray)
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 26.dp, start = 26.dp, end = 26.dp)
                .fillMaxWidth(),
        ) {
            BaseELement(
                modifier = Modifier.align(Alignment.CenterStart),
                image = R.drawable.water,
                text_1 = "49%",
                text_2 = "Humidity"
            )
            BaseELement(
                modifier = Modifier.align(Alignment.Center),
                image = R.drawable.barometr,
                text_1 = "1,007mBar",
                text_2 = "Pressure"
            )
            BaseELement(
                modifier = Modifier.align(Alignment.CenterEnd),
                image = R.drawable.wind,
                text_1 = "23 km/h",
                text_2 = "Wind"
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 26.dp, start = 26.dp, end = 26.dp)
                .fillMaxWidth(),
        ) {
            BaseELement(
                modifier = Modifier.align(Alignment.CenterStart),
                image = R.drawable.sunset, text_1 = "6:03 AM", text_2 = "Sunrise"
            )
            BaseELement(
                modifier = Modifier.align(Alignment.Center),
                image = R.drawable.dawn, text_1 = "7:05 PM", text_2 = "Sunset"
            )
            BaseELement(
                modifier = Modifier.align(Alignment.CenterEnd),
                image = R.drawable.sand_clock, text_1 = "13h 1m", text_2 = "Daytime"
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 26.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BaseCardWithElements(
                image = R.drawable.sunny,
                text_1 = "Mon, 21",
                text_2 = "35°C 26°C"
            )
            BaseCardWithElements(
                image = R.drawable.ic_sunny,
                text_1 = "Tue, 22",
                text_2 = "35°C 27°C")
            BaseCardWithElements(
                image = R.drawable.union,
                text_1 = "Wed, 22",
                text_2 = "34°C 29°C"
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose2LessTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            BaseImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), image = R.drawable.graphic
            )
            BaseColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter)
                    .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )
        }
    }
}