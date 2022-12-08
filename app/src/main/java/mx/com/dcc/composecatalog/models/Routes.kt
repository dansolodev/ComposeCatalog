package mx.com.dcc.composecatalog.models

sealed class Routes(val route: String) {
    object ScreenOne: Routes("screen1")
    object ScreenTwo: Routes("screen2")
    object ScreenThree: Routes("screen3")
}
