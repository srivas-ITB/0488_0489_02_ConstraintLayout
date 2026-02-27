package com.example.app02_constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.app02_constraintlayout.ui.theme.App02_ConstraintLayout_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App02_ConstraintLayout_Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyConstraintLayout(
                        modifier = Modifier.padding( innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()

        Box(modifier = Modifier.size(120.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(boxRed.start)
            bottom.linkTo(boxRed.top, margin = 20.dp)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxRed.start)
            top.linkTo(boxRed.bottom, margin = 20.dp)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Cyan).constrainAs(boxCyan){
            top.linkTo(boxRed.top)
            end.linkTo(boxRed.start, margin = 20.dp)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Magenta).constrainAs(boxMagenta){
            top.linkTo(boxRed.top)
            start.linkTo(boxRed.end, margin = 20.dp)
        })


        val (boxRed2, boxYellow2, boxGreen2) = createRefs()
        Box(modifier.size(50.dp).background(Color.Red).constrainAs(boxRed2){
            start.linkTo(parent.start)
            end.linkTo(boxYellow2.start)
        })
        Box(modifier.size(50.dp).background(Color.Yellow).constrainAs(boxYellow2){
            start.linkTo(boxRed2.end)
            end.linkTo(boxGreen2.start)
        })
        Box(modifier.size(50.dp).background(Color.Green).constrainAs(boxGreen2){
            start.linkTo(boxYellow2.end)
            end.linkTo(parent.end)
        })

//        createHorizontalChain(boxRed2, boxYellow2, boxGreen2, chainStyle = ChainStyle.Packed)
//        createHorizontalChain(boxRed2, boxYellow2, boxGreen2, chainStyle = ChainStyle.Spread)
//        createHorizontalChain(boxRed2, boxYellow2, boxGreen2, chainStyle = ChainStyle.SpreadInside)
//
//        createVerticalChain(boxRed2, boxYellow2, boxGreen2, chainStyle = ChainStyle.Spread)


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    App02_ConstraintLayout_Theme() {
        MyConstraintLayout()
    }
}
