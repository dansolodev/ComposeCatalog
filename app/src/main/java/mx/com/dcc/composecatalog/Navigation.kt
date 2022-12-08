package mx.com.dcc.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ScreenOne(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Screen One", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navController.navigate("screen2") }
        )
    }
}

@Composable
fun ScreenTwo(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .clickable { navController.navigate("screen3") }
    ) {
        Text(text = "Screen Two", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ScreenThree(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Screen Three", modifier = Modifier.align(Alignment.Center))
    }
}