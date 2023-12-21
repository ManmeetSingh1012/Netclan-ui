package com.app.netclanexplorer.UILayer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.netclanexplorer.Navigation.Screen
import com.app.netclanexplorer.R
import com.app.netclanexplorer.common
import com.app.netclanexplorer.ui.theme.blue_primary
import com.app.netclanexplorer.ui.theme.blue_secondry
import com.app.netclanexplorer.ui.theme.grey
import com.app.netclanexplorer.ui.theme.white_color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun Explore(navHostController: NavHostController)
{

    val list_bottom_items = listOf<common>(
        common("Explore",R.drawable.eye) ,
        common("Network",R.drawable.network),
    common("Chat",R.drawable.chat),
    common("Contacts",R.drawable.contacts),
    common("Groups",R.drawable.hastag),

    )

    val pagerstate = rememberPagerState()
    val scope = rememberCoroutineScope()
    val list_pager = listOf("Personal","Business","Merchant")
    val search = remember{
        mutableStateOf("")
    }

    Scaffold(
        // top app bar
        topBar = {

                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .background(color = blue_primary),
                           verticalAlignment = Alignment.CenterVertically) {

                           Icon(painter = painterResource(id = R.drawable.menu), contentDescription = "menu", modifier = Modifier
                               .weight(0.1f)
                               .padding(top = 4.dp, bottom = 4.dp, start = 5.dp), tint = white_color)

                           Spacer(modifier = Modifier.width(20.dp))

                           Column(modifier = Modifier
                               .weight(0.7f)
                               .padding(top = 4.dp, bottom = 5.dp)) {


                               Text(text = "Howdy Manmeet Singh !!",
                                   fontSize = 15.sp, color = white_color,
                                   fontWeight = FontWeight.SemiBold)

                               Spacer(modifier = Modifier.height(3.dp))

                               Row(horizontalArrangement = Arrangement.Start) {

                                   Icon(painter = painterResource(id = R.drawable.location),
                                       contentDescription = "menu", tint = white_color, modifier = Modifier.size(15.dp))

                                   Text(text = "Field Ganj, Ludhiana",
                                       fontSize = 13.sp,
                                               color = white_color,
                                       fontWeight = FontWeight.Normal)
                               }

                           }

                           Column(modifier = Modifier
                               .weight(0.2f)
                               .padding(top = 4.dp, bottom = 5.dp, end = 5.dp),
                               horizontalAlignment = Alignment.CenterHorizontally,
                               verticalArrangement = Arrangement.Center) {



                               IconButton(onClick = { navHostController.navigate(Screen.Refine.route) }) {
                                   Icon(painter = painterResource(id = R.drawable.checklist),
                                       contentDescription = "menu", tint = white_color, modifier = Modifier.size(25.dp))
                               }

                               Text(text = "Refine", fontSize = 13.sp, color = white_color, fontWeight = FontWeight.Normal)
                           }
                       }
// from here main screen starts
    } ,     content = {
                Column(
                 modifier = Modifier
                     .fillMaxSize()
                     .background(color = white_color)
                     .padding(
                         top = it
                             .calculateTopPadding(), bottom = it.calculateBottomPadding()

                     )
                ) {





                    // screens
            TabRow(selectedTabIndex = pagerstate.currentPage,
                indicator = {
                        tabPositions ->  TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerstate,tabPositions),
                    color = white_color

                )

                }, backgroundColor = blue_secondry) {

                list_pager.forEachIndexed { index, s ->
                    Tab(selected = pagerstate.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerstate.animateScrollToPage(page = index)
                            }
                        }, selectedContentColor = white_color) {

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = s,  color = if(pagerstate.currentPage ==  index) white_color else grey)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }

            }


                    Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 0.dp, end = 20.dp), verticalAlignment = Alignment.Top) {

                        Surface(modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.9f),shape = RoundedCornerShape(20.dp) , color = white_color, border = BorderStroke(0.3f.dp,color = blue_primary)
                        )
                        {
                            TextField(


                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),

                                value = search.value,

                                onValueChange = {
                                    search.value = it },

                                placeholder = {

                                    
                                    Text(text = "Search",color = grey , modifier = Modifier.alpha(ContentAlpha.high), fontSize = 14.sp)
                                },



                                singleLine = true,

                                leadingIcon = {
                                    androidx.compose.material.IconButton(onClick = { /*TODO*/ },
                                        modifier = Modifier.alpha(ContentAlpha.high)) {

                                        androidx.compose.material.Icon(imageVector = Icons.Default.Search , contentDescription = "search icon"
                                            , tint = grey)
                                    }


                                }
                                ,



                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.Transparent,
                                    cursorColor = grey,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        IconButton(onClick = { navHostController.navigate(Screen.Refine.route) },modifier = Modifier
                            .weight(0.1f)) {
                            Icon(painter = painterResource(id = R.drawable.checklist),
                                contentDescription = "menu", tint = blue_primary, modifier = Modifier
                                    .size(25.dp)
                                    .alpha(ContentAlpha.high))
                        }

                    }
                    // screen data


            HorizontalPager(
                count = list_pager.size,
                state = pagerstate, modifier = Modifier.weight(1f)) { it ->

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)) {


                   LazyColumn(content = {
                       items(count = 5)
                       {
                           main_items()
                           Spacer(modifier = Modifier.height(5.dp))
                       }
                   })
                }

            }
        }
    },


        // bottom bar item
        bottomBar = {


            BottomAppBar(containerColor = white_color) {


                list_bottom_items.forEach{

                    NavigationBarItem(selected = false ,
                        onClick = { /*TODO*/ },

                        icon = {
                            Icon(painter = painterResource(id = it.image), contentDescription = "image"
                            , modifier = Modifier.size(25.dp))
                        }

                    , label =  {
                        Text(text = it.name)
                        },

                        colors = NavigationBarItemDefaults.colors(indicatorColor = white_color)
                    )


                }


            }
        }

        )
}


