# Compose_Navigation
Compose Bottom and Deep Link Navigation.

1. NavController - It manages all navigations inside NavHost, It navigates to individual destinations and shows up corresponding composable screen.

    ➡️ ` val navController = rememberNavConrroller() `

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
