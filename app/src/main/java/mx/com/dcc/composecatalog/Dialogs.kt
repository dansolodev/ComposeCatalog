package mx.com.dcc.composecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import mx.com.dcc.composecatalog.ui.theme.ComposeCatalogTheme

@Composable
@Preview(showBackground = true)
fun DialogsPreview() {
    ComposeCatalogTheme() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            MyConfirmationDialog(show = true) {

            }
        }
    }
}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
                var status by remember {
                    mutableStateOf("")
                }
                MyRadioButtonList(name = status, onItemSelected = { status = it })
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
                Row(modifier = Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "email@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "email2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}


@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Simple Dialog")
            }
        }
    }
}

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Title") },
            text = { Text(text = "Hola soy una descripción") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            }
        )
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}