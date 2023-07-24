package com.implementing.engagecode.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.implementing.engagecode.R

@Composable
fun AppHomeNavigation(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.cardList
    ) {
        composable(route = Route.cardList) {
            CardList(
                navigateToDetail = {
                    navController.navigate(Route.cardDetail)
                }
            )
        }

        composable(route = Route.cardDetail) {
            CardDetail(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}

object Route {
//    similar to final int in java, in kotlin const val
    const val cardList = "cardList"
    const val cardDetail = "cardDetail"
}

@Composable
fun CardList(
    navigateToDetail: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(65.dp)
                .fillMaxWidth()
                .clickable(onClick = navigateToDetail),

            colors = CardDefaults.cardColors(
                containerColor =  Color(0xFFD5BDC6)
            )
        ) {

            Text(
                text = "Card One",
                color = Color.DarkGray,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.ic_home_empty
                ),
                contentDescription = "",
                modifier = Modifier.padding(2.dp).align(Alignment.CenterHorizontally)

            )
        }
    }
}

@Composable
fun CardDetail(
    navigateBack: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Card(
            modifier = Modifier
                .padding(65.dp)
                .fillMaxWidth()
                .clickable(onClick = navigateBack),

            colors = CardDefaults.cardColors(
                containerColor =  Color(0xffF4EAEE),
            )
        ) {

            Text(
                text = "Detail of the Card One",
                color = Color.DarkGray,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(15.dp).align(Alignment.CenterHorizontally)
            )
        }

    }
}