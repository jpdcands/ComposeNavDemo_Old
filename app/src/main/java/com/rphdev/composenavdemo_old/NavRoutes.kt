package com.rphdev.composenavdemo_old

sealed class NavRoutes(val route: String) {
    object LoginScreen : NavRoutes("loginscreen")
    object ScreenOne : NavRoutes("screenone")
    object ScreenTwo : NavRoutes("screentwo")
}
