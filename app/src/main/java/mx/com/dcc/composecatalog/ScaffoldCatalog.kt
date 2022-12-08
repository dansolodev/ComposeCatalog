package mx.com.dcc.composecatalog


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
            }
        }
    }, scaffoldState = scaffoldState, bottomBar = { MyBottomNavigation() }) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "My first Toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 8.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Back") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back button")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search button")
            }
            IconButton(onClick = { onClickIcon("Calendar") }) {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Date button")
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White,
    ) {
        BottomNavigationItem(
            selected = index == 0, onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home option"
                )
            }, label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = index == 1, onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite option"
                )
            }, label = { Text(text = "Favorite") }
        )
        BottomNavigationItem(
            selected = index == 2, onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person option"
                )
            }, label = { Text(text = "Person") }
        )
    }
}