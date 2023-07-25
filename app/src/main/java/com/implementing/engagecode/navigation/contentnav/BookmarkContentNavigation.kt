package com.implementing.engagecode.navigation.contentnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.implementing.engagecode.R
import com.implementing.engagecode.data.BookMark

@Composable
fun AppBookmarkNavigation(){
    val navController = rememberNavController()

    val bookMark = listOf(
        BookMark("Dhoni Bookmark", R.drawable.dhoni),
        BookMark("Virat Bookmark", R.drawable.virat),
        BookMark("Rohit Bookmark", R.drawable.rohit)
    )

    NavHost(navController = navController, startDestination = MarkRoute.bookList){

        composable(route = MarkRoute.bookList){
            BookList(
                bookMark = bookMark,
                navigateToDetail = { bookTitle ->
                    navController.navigate("${MarkRoute.bookDetail}/$bookTitle")
                }
            )
        }


        composable(route = "${MarkRoute.bookDetail}/{bookTitle}"){ backStackEntry ->
            BookDetail(bookTitle = backStackEntry.arguments?.getString("bookTitle") ?: "")
        }



    }
}



object MarkRoute{
    const val bookList = "bookList"
    const val bookDetail = "bookDetail"
}

@Composable
fun BookList(
    bookMark: List<BookMark>,
    navigateToDetail: (String) -> Unit
){
    LazyColumn(modifier = Modifier.padding(top = 60.dp)) {
        items(bookMark) { bookMarkItem ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable{ navigateToDetail(bookMarkItem.title)},

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD5BDC6)
                )
            ) {

                Text(
                    text = bookMarkItem.title,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Image(
                    painter = painterResource(
                        id = bookMarkItem.image
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

        }
    }

}

@Composable
fun BookDetail(
    bookTitle : String
){
    Card(
        modifier = Modifier
            .padding(65.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD5BDC6)
        )
    ) {

        Text(
            text = "Detail of $bookTitle",
            color = Color.DarkGray,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}
