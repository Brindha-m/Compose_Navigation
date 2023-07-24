package com.implementing.engagecode.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen()
{
    AppHomeNavigation()
}


@Composable
fun NotificationScreen()
{
    Text(
        text = "This is Notification Screen",
        color = Color.LightGray,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        overflow = TextOverflow.Visible,
        modifier = Modifier.padding(70.dp)
    )
}


@Composable
fun BookmarkScreen()
{
    Text(
        text = "This is Bookmark Screen",
        color = Color.DarkGray,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        modifier = Modifier.padding(70.dp)
    )
}

@Composable
fun ProfileScreen()
{
    Text(
        text = "This is Profile Screen",
        color = Color.DarkGray,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        modifier = Modifier.padding(70.dp)
    )
}





