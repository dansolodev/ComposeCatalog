package mx.com.dcc.composecatalog


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
    }, scaffoldState = scaffoldState) {

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