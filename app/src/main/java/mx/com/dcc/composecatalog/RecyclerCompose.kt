package mx.com.dcc.composecatalog

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mx.com.dcc.composecatalog.ui.theme.ComposeCatalogTheme

@Composable
fun SimpleRecyclerView() {
    val mList = listOf("Jacke", "Sam", "Rupi", "Rocket")
    LazyColumn {
        item {
            Text(text = "PrimerItem")
        }
        items(7) {
            Text(text = "Este es el item: $it")
        }
        items(mList) {
            Text(text = "Mascoto: $it")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun SimpleRecyclerViewPreview() {
    ComposeCatalogTheme {
        SimpleRecyclerView()
    }
}