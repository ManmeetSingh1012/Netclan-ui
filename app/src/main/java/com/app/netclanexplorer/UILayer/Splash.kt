package com.app.netclanexplorer.UILayer




import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.netclanexplorer.Navigation.Screen
import com.app.netclanexplorer.R
import kotlinx.coroutines.delay


// this is the splash screen or the first loading screen

@Composable
fun Splash(navHostController: NavHostController)
{

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        , modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo", modifier = Modifier.size(200.dp) )
    }

    LaunchedEffect(key1 = true, block ={

        delay(1000)
        navHostController.navigate(Screen.Explore.route)
    } )
}