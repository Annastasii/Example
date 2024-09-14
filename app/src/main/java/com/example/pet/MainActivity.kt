package com.example.pet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.route.AuthDestination
import com.example.core_navigation.route.DialogListDestination
import com.example.pet.navigation.globalGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(navController: NavHostController,viewModel: MainViewModel = hiltViewModel()) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = AuthDestination.route()
    ) { globalGraph(context, navController) }
}
