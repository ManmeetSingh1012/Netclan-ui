package com.app.netclanexplorer.UILayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.netclanexplorer.ui.theme.blue_primary
import com.app.netclanexplorer.ui.theme.blue_secondry
import com.app.netclanexplorer.ui.theme.grey
import com.app.netclanexplorer.ui.theme.white_color

@Composable
fun main_items()
{
    Surface(shape = RoundedCornerShape(20.dp) , color = white_color, tonalElevation = 6.dp , shadowElevation = 6.dp
    , modifier = Modifier
            .padding(start = 5.dp,  top = 20.dp, end = 5.dp)
            .background(color = white_color).fillMaxWidth()) {

        Column(modifier = Modifier.padding(15.dp), verticalArrangement = Arrangement.Top ) {

            Text(
                text = "+INVITE",
                color = blue_primary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row(verticalAlignment = Alignment.Top , horizontalArrangement = Arrangement.Start) {

                Card(
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(containerColor = grey)
                ) {

                    Text(
                        text = "MS",
                        color = blue_primary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(start = 12.dp , end = 12.dp , top = 16.dp , bottom = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column() {
                    Text(
                        text = "Manmeet Singh",
                        color = blue_primary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Ludhiana | Student",
                        color = blue_secondry,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Within 600m",
                        color = blue_primary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }

            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Coffee | Business | Freindship",
                color = blue_primary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Hi Community I am open to new connection",
                color = blue_secondry,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "I am gratuate student looking for work form Home or intership or full time ",
                color = blue_secondry,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                textAlign = TextAlign.Justify
            )

        }

    }
}