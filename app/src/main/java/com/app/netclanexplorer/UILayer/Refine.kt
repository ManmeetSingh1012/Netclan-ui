package com.app.netclanexplorer.UILayer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.netclanexplorer.R
import com.app.netclanexplorer.ui.theme.blue_secondry
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.app.netclanexplorer.ui.theme.grey
import com.app.netclanexplorer.ui.theme.white_color
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Refine()
{

    var expand_list = remember {
        mutableStateOf(false)
    }

    var sliderPosition =  remember { mutableStateOf(0f) }

    val maxChar = 250

    var current_status = remember {
        mutableStateOf("Hi community | I am open to new connections")
    }

    val availablity_item = listOf<String>(
        "Avaiable | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do Not Disturb | Will Catch Up Later",
        "SOS | Emergency Need Assistance | HELP")




    var purpose = listOf<String>("Coffe","Business","Hobbies","Friendship","Movies","Dininig","Dating","Matermoney")




    var availability_current_text = remember{
        mutableStateOf(availablity_item[0])
    }

    Scaffold( topBar = {

        // top app bar
        TopAppBar(
            title = {
                Text(text = "Refine", color = Color.White, fontSize = 16.sp)
            },
            navigationIcon = {

                IconButton(onClick = { /*TODO*/ }) {

                    Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "icon",
                    tint = Color.White)
                }
            }, colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = blue_secondry)
        )

        // main screen contents
    } , content =  {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = white_color)
            .padding(
                top = it
                    .calculateTopPadding()
                    .plus(20.dp), start = 20.dp, end = 20.dp
            )) {

            // selecting availbility
            Text(
                text = "Select Your Availability",
                color = blue_secondry,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(45.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.5f.dp, blue_secondry)
            )
            {

                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(start = 5.dp)
                        .background(color = Color.White)
                        .clickable {
                            expand_list.value = true
                        }, verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = availability_current_text.value,
                        color = blue_secondry,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp, modifier = Modifier.weight(0.8f)
                    )



                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "icon",
                        tint = blue_secondry,
                        modifier = Modifier.weight(0.1f)
                    )

                }

                // drop down menu show the list
            DropdownMenu(expanded = expand_list.value,
                onDismissRequest = { expand_list.value = false }, modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(0.9f)) {


                availablity_item.forEach {

                    DropdownMenuItem(text = {

                        Text(
                            text = it, color = blue_secondry,
                            fontSize = 14.sp,fontWeight = FontWeight.Normal
                        )
                    },

                        onClick = {
                            availability_current_text.value = it
                            expand_list.value = false
                        })
                }
            }
        }

            Spacer(modifier = Modifier.height(20.dp))

            // adding status
            Text(
                text = "Add Your Status",
                color = blue_secondry,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(value = current_status.value,
                onValueChange = {
                    current_status.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                ,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = blue_secondry,
                    textColor = blue_secondry, cursorColor = blue_secondry
                ),

                supportingText = {
                    Text(
                        text = "${current_status.value.length} / $maxChar",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                    )
                },
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = blue_secondry,
                    fontWeight = FontWeight.Normal

                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

            )



            // distance slider
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Select Hyper Local Distance",
                color = blue_secondry,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            Slider(
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                value = sliderPosition.value,
                onValueChange = { sliderPosition.value = it },
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(activeTickColor =  blue_secondry,
                    activeTrackColor = blue_secondry,
                inactiveTickColor = blue_secondry,
                    inactiveTrackColor = grey, disabledActiveTickColor = blue_secondry, disabledActiveTrackColor = blue_secondry
                , thumbColor = blue_secondry, disabledThumbColor = blue_secondry, disabledInactiveTickColor = blue_secondry, disabledInactiveTrackColor = grey),

                 thumb = {
                    Surface( shape = CircleShape, color = blue_secondry) {

                        Text(
                            text = " ${sliderPosition.value.toInt()} ",
                            color = white_color,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(5.dp),
                            fontSize = 12.sp
                        )

                    }
                }
            )



            Row(modifier = Modifier.fillMaxWidth())
            {
                Text(
                    text = "0 km",
                    color = blue_secondry,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(0.1f),
                    fontSize = 14.sp
                )

                Text(
                    text = "",
                    color = blue_secondry,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(0.7f),
                    fontSize = 14.sp
                )

                Text(
                    text = "100 Km",
                    color = blue_secondry,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(0.2f),
                    fontSize = 14.sp
                )
            }



             // purpose selector
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Select Purpose",
                color = blue_secondry,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                mainAxisSpacing = 8.dp, // Adjust spacing between items
                crossAxisSpacing = 1.dp, // Adjust spacing between rows
                 // Alignment of items within each row
                content = {
                    
                    button()

                    
                }
            )


            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {

                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
                ,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = blue_secondry)
            ) {

                Text(
                    "Save & Explore",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,

                )
            }

        }

        // this will the change the color of the background
    }, containerColor = Color.Transparent)


}


// purpose button selector
@Composable
fun button()
{

    var selected_list0 = remember {
        mutableStateOf(true)
    }

    var selected_list1 = remember {
        mutableStateOf(true)
    }
    var selected_list2 = remember {
        mutableStateOf(true)
    }

    var selected_list3 = remember {
        mutableStateOf(true)
    }
    var selected_list4 = remember {
        mutableStateOf(true)
    }
    var selected_list5 = remember {
        mutableStateOf(true)
    }
    var selected_list6 = remember {
        mutableStateOf(true)
    }
    var selected_list7 = remember {
        mutableStateOf(true)
    }

        Button(
            onClick = {
                selected_list0.value = !selected_list0.value
            }
            , border = BorderStroke(width = 0.5.dp,color = blue_secondry),
            
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = if(selected_list0.value == false ) blue_secondry else white_color)
        ) {

            Text(
                "Coffee",
                color = if(selected_list0.value == false ) white_color else blue_secondry,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,

                )
        }


    Button(
        onClick = {
            
              selected_list1.value = !selected_list1.value
                
        },
         border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list1.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Business",
            color = if(selected_list1.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }



    Button(
        onClick = {
            
               selected_list2.value = !selected_list2.value
            
        },
       border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list2.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Dating",
            color = if(selected_list2.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }

    Button(
        onClick = {

            selected_list3.value = !selected_list3.value

        },
        border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list3.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Hobbies",
            color = if(selected_list3.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }


    Button(
        onClick = {

            selected_list4.value = !selected_list4.value

        },
        border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list4.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Friendship",
            color = if(selected_list4.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }


    Button(
        onClick = {

            selected_list5.value = !selected_list5.value

        },
        border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list5.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Movies",
            color = if(selected_list5.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }


    Button(
        onClick = {

            selected_list6.value = !selected_list6.value

        },
        border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list6.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Dinnning",
            color = if(selected_list6.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }


    Button(
        onClick = {

            selected_list7.value = !selected_list7.value

        },
        border = BorderStroke(width = 0.5.dp,color = blue_secondry)
        ,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if(selected_list7.value == false ) blue_secondry else white_color)
    ) {

        Text(
            "Matrimony",
            color = if(selected_list7.value == false ) white_color else blue_secondry,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,

            )
    }
    
}