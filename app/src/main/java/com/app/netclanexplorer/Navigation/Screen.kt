package com.app.netclanexplorer.Navigation

sealed class Screen(val route:String)
{
    object Explore :Screen("Refine")
    object Refine : Screen("Explore")
    object Splash : Screen("Splash")
}
