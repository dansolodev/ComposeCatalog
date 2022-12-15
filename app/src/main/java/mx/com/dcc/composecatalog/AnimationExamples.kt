package mx.com.dcc.composecatalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationSimple() {
    Column {
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }
        var realColor = if (firstColor) Color.Red else Color.Yellow
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }
        )
        Spacer(modifier = Modifier.size(200.dp))
        var showBox by rememberSaveable {
            mutableStateOf(true)
        }
        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColorTwo by animateColorAsState(
            targetValue = if (firstColor) Color.Red else Color.Yellow,
            animationSpec = tween(
                durationMillis = 2000
            ),
            finishedListener = { showBox = false }
        )
        if (showBox) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColorTwo)
                    .clickable { secondColor = !secondColor }
            )
        }
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 200)
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(Color.DarkGray)
            .clickable { smallSize = !smallSize }
    )
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Show/Hide")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(isVisible) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
fun CrossFadeExampleAnimation() {
    var myComponentType: ComponentType by rememberSaveable {
        mutableStateOf(ComponentType.Text)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType) {
            when (it) {
                ComponentType.Image -> Icon(Icons.Default.Send, contentDescription = "")
                ComponentType.Text -> Text(text = "Soy un componente")
                ComponentType.Box -> Box(modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red))
                ComponentType.Error -> Text(text = "ERROR!")
            }

        }
    }
}

fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType {
    Image, Text, Box, Error
}