package com.me.simplenavigationcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.me.simplenavigationcompose.screens.DetailsScreen
import com.me.simplenavigationcompose.screens.MainScreen
import com.me.simplenavigationcompose.screens.Screen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ){
        composable( route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
//            route = Screen.DetailsScreen.route + "/{name}",
            route = Screen.DetailsScreen.route + "/?name={name}", //nullable
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "default name"
                    nullable = true
                }
            )
        ){ entry ->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }
}

