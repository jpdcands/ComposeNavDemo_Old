package com.rphdev.composenavdemo_old

import android.os.Bundle
import android.widget.Button
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics.composable
import androidx.compose.material.Button
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rphdev.composenavdemo_old.NavGraphs.root
import com.rphdev.composenavdemo_old.destinations.LoginScreenDestination
import com.rphdev.composenavdemo_old.destinations.ScreenOneDestination
import com.rphdev.composenavdemo_old.destinations.ScreenTwoDestination
import com.rphdev.composenavdemo_old.ui.theme.ComposeNavDemo_OldTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavDemo_OldTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = NavRoutes.LoginScreen.route,
                ) {
                    composable(NavRoutes.LoginScreen.route) {
                        LoginScreen(navController = navController)
                    }

                    composable(NavRoutes.ScreenOne.route) {
                        ScreenOne(navController = navController)
                    }

                    composable(NavRoutes.ScreenTwo.route) {
                        ScreenTwo(navController = navController)
                    }
                }
            }
            TopAppBar(
                title = {
                    Text(text = "Compose = Old Navigation")
                })
        }
    }
}

@Composable
fun LoginScreen(
    navController : NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login Screen",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(top = 160.dp, bottom = 140.dp)
                .border(4.dp, Color.Black, RectangleShape)
                .padding(15.dp)
        )
        Button(onClick = {
            navController.navigate(NavRoutes.ScreenOne.route)
        }) {
            Text("Go to Screen 1")
        }
    }
}

@Composable
fun ScreenOne(
    navController : NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 1",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(top = 100.dp, bottom = 140.dp)
                .border(4.dp, Color.Black, RectangleShape)
                .padding(15.dp)
        )
        Button(onClick = {
            navController.navigate(NavRoutes.ScreenTwo.route)
        }) {
            Text("Go to Screen 2")
        }
    }
}
@Composable
fun ScreenTwo(
    navController : NavHostController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 2",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(top = 160.dp, bottom = 140.dp)
                .border(4.dp, Color.Black, RectangleShape)
                .padding(15.dp)
        )
        Button(onClick = {
            navController.navigate(NavRoutes.LoginScreen.route)
        }) {
            Text("Go to  LogIn Screen")
        }
    }
}