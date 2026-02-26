package com.example.app01_helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app01_helloandroid.ui.theme.App01_HelloAndroid_Theme

class MainActivity_2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App01_HelloAndroid_Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(verticalArrangement = Arrangement.SpaceEvenly) {
                        Greeting2(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        MyRow(
                            modifier = Modifier.padding(innerPadding)
                        )
                        MyColumn(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyRow(modifier: Modifier = Modifier) {
    val numItems = 10
    Text("$numItems elements amb Scroll Horitzontal")
    Row(modifier.horizontalScroll(rememberScrollState())) {
        for (i in 1..numItems) {
            Text("**Text line $i** ")
        }
    }
}

@Composable
fun MyColumn(modifier: Modifier = Modifier) {
    val colors = mutableListOf( Color.Cyan, Color.Yellow, Color.Green, Color.Magenta, Color.Gray, Color.Blue, Color.Red)
    val numItems = 100
    Text("$numItems elements amb Scroll Vertical")
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(550.dp)
            .background(Color.Red)
    ) {
        Column(modifier.verticalScroll(rememberScrollState())) {
            for (i in 1..numItems) {
                Text("Text line $i ", Modifier.background(colors[i % colors.size]) )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    App01_HelloAndroid_Theme() {
        Greeting2("Android")
    }
}
