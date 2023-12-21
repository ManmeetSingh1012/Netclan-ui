package com.app.netclanexplorer.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.netclanexplorer.UILayer.Explore
import com.app.netclanexplorer.UILayer.Refine
import com.app.netclanexplorer.UILayer.Splash

@Composable
fun graph(navHostController: NavHostController)
{
    NavHost(navController = navHostController, startDestination = Screen.Splash.route )
    {
        composable(Screen.Explore.route)
        {
            Explore(navHostController)
        }

        composable(Screen.Splash.route)
        {
            Splash(navHostController)
        }

        composable(Screen.Refine.route)
        {
            Refine()
        }
    }
}