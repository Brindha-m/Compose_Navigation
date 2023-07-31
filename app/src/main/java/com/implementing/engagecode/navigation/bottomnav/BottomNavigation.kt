package com.implementing.engagecode.navigation.bottomnav

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable
import com.implementing.engagecode.R
import com.implementing.engagecode.navigation.BookmarkScreen
import com.implementing.engagecode.navigation.HomeScreen
import com.implementing.engagecode.navigation.NotificationScreen
import com.implementing.engagecode.navigation.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navigationBarItems = remember {
        NavigationBarItems.values()
    }

    var selectedIndex by remember {
        mutableStateOf(0)
    }


    Scaffold(
        modifier = Modifier.padding(7.dp),

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Engage Code", color = Color.LightGray, fontFamily = FontFamily.Monospace, fontSize = 16.sp )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent)
            )
        },

        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier.height(64.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationBarItems.forEach { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable { selectedIndex = item.ordinal },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = "Bottom Bar",
                            tint = if (selectedIndex == item.ordinal) MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            }
        }
    ) {
        // Display different content based on the selectedIndex
        when (navigationBarItems[selectedIndex]) {
            NavigationBarItems.Home -> HomeScreen()
            NavigationBarItems.Notification -> NotificationScreen()
            NavigationBarItems.Bookmark -> BookmarkScreen()
            NavigationBarItems.Profile -> ProfileScreen()

        }
    }
}

/* List of Bottom nav items can include names also */

enum class NavigationBarItems(@DrawableRes val icon: Int){
    Home(icon = R.drawable.ic_home_empty),
    Notification(icon = R.drawable.ic_notifications),
    Bookmark(icon = R.drawable.ic_bookmark),
    Profile(icon = R.drawable.ic_profile_empty)

}


