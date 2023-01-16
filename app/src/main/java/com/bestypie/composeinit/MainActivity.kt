package com.bestypie.composeinit

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bestypie.composeinit.ui.theme.ComposeInitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInitTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    // Manages the state of the UI - Helps us to hold the state
    var counter = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFFABC270)
    ) {
        Column(modifier = Modifier,
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ) {
            Text(text = "${counter.value}", style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(counter = counter.value) { newValue ->
                counter.value = newValue
            }
        }


    }
}

//@Preview
@Composable
fun CreateCircle(counter: Int = 100, updateCounter: (Int) -> Unit) {


    Card(modifier = Modifier
        .padding(3.dp)
        .width(105.dp)
        .height(105.dp)
        .clickable {
                   updateCounter(counter + 1)
                   }
        , shape = CircleShape) {
        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
            Text(text = "Tap $counter", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 39.sp))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeInitTheme {
        Column {
            MyApp()
            CreateCircle(0) {}
        }

    }
}