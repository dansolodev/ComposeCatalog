package mx.com.dcc.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mx.com.dcc.composecatalog.models.Routes
import mx.com.dcc.composecatalog.ui.theme.ComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CrossFadeExampleAnimation()
                    /*Column(modifier = Modifier.fillMaxSize()) {
                        // MyTextFieldStataHoisting
                        /*var myText by remember {
                            mutableStateOf("")
                        }
                        MyTextFieldStataHoisting(myText) { myText = it }*/
                        /*val options = getOptions(titles = listOf("Unos", "Dos", "Tres", "Cuatro"))
                        options.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }*/
                        /*var selected by remember {
                            mutableStateOf("Jacke")
                        }
                        MyRadioButtonList(selected) {
                            selected = it
                        }*/

                    }*/
                    /*var show by remember {
                        mutableStateOf(false)
                    }
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                        *//*MyAlertDialog(
                            show = show,
                            onDismiss = { show = false},
                            onConfirm = { }
                        )*//*
                        //MySimpleCustomDialog(show = show, onDismiss = { show = false })
                        MyCustomDialog(show = show) {
                            show = false
                        }
                    }*/
                    /*val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.ScreenOne.route
                    ) {
                        composable(Routes.ScreenOne.route) { ScreenOne(navigationController) }
                        composable(Routes.ScreenTwo.route) { ScreenTwo(navigationController) }
                        composable(Routes.ScreenThree.route) { ScreenThree(navigationController) }
                        composable(
                            Routes.ScreenFour.route,
                            arguments = listOf(
                                navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            ScreenFour(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.ScreenFive.route,
                            arguments = listOf(
                                navArgument("name") { defaultValue = "" }
                            )
                        ) { backStackEntry ->
                            ScreenFive(
                                navigationController,
                                backStackEntry.arguments?.getString("name")
                            )

                        }
                    }*/
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCatalogTheme {
        //MyDialog(true)
    }
}

@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable {
        mutableStateOf("")
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val desserts = listOf("Pastel", "Helado", "Café", "Fruta", "Chilaquiles")
    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = dessert
                }) {
                    Text(text = dessert)
                }
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(modifier = Modifier.fillMaxWidth(), color = Color.DarkGray)
}

@Composable
fun MyBadgeBox() {
    BadgedBox(badge = { Badge { Text(text = "8") } }, modifier = Modifier.padding(16.dp)) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Gray,
        contentColor = Color.DarkGray,
        border = BorderStroke(5.dp, Color.Black)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo de CARD")
        }

    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Jacke", onClick = { onItemSelected("Jacke") })
            Text(text = "Jacke")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Rupi", onClick = { onItemSelected("Rupi") })
            Text(text = "Rupi")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Coco", onClick = { onItemSelected("Coco") })
            Text(text = "Coco")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Sam", onClick = { onItemSelected("Sam") })
            Text(text = "Sam")
        }
    }
}

@Composable
fun MyRadioButton() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state,
            onClick = { },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyTriStateCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { newStatus -> status = newStatus }
        )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBox() {
    // Para trabajar CheckBox siempre hay que usar estados
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Green,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MySwitch() {
    // Para trabajar switch siempre hay que usar estados
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan
        )
    )
}

@Composable
fun MyProgressBarAdvance() {
    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus)
        Row(modifier = Modifier.fillMaxSize()) {
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator()
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp))
        }
        Button(onClick = { showLoading = !showLoading }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Load!")
        }
    }
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icon", tint = Color.Yellow)
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        modifier = Modifier
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example"
    )
}

@Composable
fun MyButtonExample() {
    var isEnable by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { isEnable = false },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, color = Color.Green),
            enabled = isEnable
        ) {
            Text(text = "Hello world!")
        }

        OutlinedButton(onClick = { }, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Hello World!")
        }

        TextButton(onClick = { }, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Hello World!")
        }

    }
}

@Composable
fun MyTextFieldStataHoisting(name: String, onValueChange: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChange(it) })
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = myText, onValueChange = {
            myText = it
        },
        modifier = Modifier.padding(all = 24.dp),
        label = { Text(text = "Hello") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") }
    )
}

@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(value = myText, onValueChange = {
        myText = it
    })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}

@Composable
fun MyStateExample() {
    // remember matiene el estado con el composable se recrea, pero no cuando la activity se destruye y se vuelve a crear
    // rememberSaveable si mantiene el estado aun que la activity se recree.
    // by se covina de var para que no tengamos que acceder al .value
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Esto es un ejemplo")
        }
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo Uno",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ejemplo Dos",
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ejemplo Tres",
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ejemplo Cuatro",
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(80.dp)
        )
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2")
        Text(text = "Ejemplo 3")
    }
}
