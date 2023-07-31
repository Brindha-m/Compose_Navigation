# Compose_Navigation
Compose Bottom and Deep Link Navigation.

1. NavController - It manages all navigations inside NavHost, It navigates to individual destinations and shows up corresponding composable screen.

    ➡️ ` val navController = rememberNavController() `

2. NavHost - Its a composable which specifies all possible composable destinations inside using composable keyword.
           - NavHost is a function which takes navController and startDestination as parameters.

     ```
       NavHost(navController = navController, startDestination = startDestination) {

         composable(route = "home"){
             HomeScreen()
         }
  
         composable(route = Route.about){
             AboutScreen()
          }

          composable(route = Route.cardList){
             ListScreen(
                  navigateToDetail = {
                    navController.navigate(Route.cardDetail)
                }
             )
          }
     
     }
     
     ```

3. In ListScreen Composable,
   
            @Composable
            fun ListScreen(navigateToDetail:() -> Unit)
            {
               Card(
                    modifier = Modifier
                        .padding(65.dp)
                        .fillMaxWidth()
                        .clickable(onClick = navigateToDetail), // 👉🏻 onClick implement the route variable.
   
                   ){
                      Text()
                      Icon() //Other Composable elements..
                   }

             }


4. For Bottom Screen,
   
       Scaffold(
   
           modifier = Modifier.padding(5.dp),
       
           topBar = { TopAppBar(title ={}, color = Color.Transparent ) },
       
           bottomBar = { AnimatedNavigationBar() // Depends and changes accordingly }

       ) {
               // Nav to Diff Composable Screens 
   
       }


5. List of Bottom nav items can include names also ex: NavigationItems(val route : String, @DrawableRes val icon : Int, etc.. )

        enum class NavigationBarItems(@DrawableRes val icon: Int){
   
            Home(icon = R.drawable.ic_home_empty),
   
            Notification(icon = R.drawable.ic_notifications),
   
            Bookmark(icon = R.drawable.ic_bookmark),
   
            Profile(icon = R.drawable.ic_profile_empty)
        
        }
