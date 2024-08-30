package com.example.moviesapplicationcm.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviesapplicationcm.R
import com.example.moviesapplicationcm.ui.screens.LogInScreen
import com.example.moviesapplicationcm.ui.screens.MovieDetailsPreview
import com.example.moviesapplicationcm.ui.screens.MovieDetailsScreen
import com.example.moviesapplicationcm.ui.screens.MovieListScreen
import com.example.moviesapplicationcm.ui.theme.MoviesApplicationCMTheme

/**
 * enum values that represent the screens in the app
 */
enum class MovieAppScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Movies(title = R.string.Movies),
    MovieDetails(title = R.string.Movie_Details),
}


@Composable
fun MoviesApp(
    navController: NavHostController = rememberNavController(),
    movieViewModel: MovieViewModel = viewModel(factory = MoviesViewModelProvider.Factory)
) {
    val uiState by movieViewModel.uiState.collectAsState()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MovieAppScreen.valueOf(
        backStackEntry?.destination?.route ?: MovieAppScreen.Start.name
    )

        NavHost(
            navController = navController,
            startDestination = MovieAppScreen.Start.name,
        ) {

            composable(route = MovieAppScreen.Start.name) {
                LogInScreen(
                    onKeyboardDone = { navController.navigate(MovieAppScreen.Movies.name) },
                    onFabPressed = { navController.navigate(MovieAppScreen.Movies.name) })
            }

            composable(route = MovieAppScreen.Movies.name) {
                movieViewModel.tryToPrint()
                MovieListScreen(myViewModel = movieViewModel, onDetailsPressed = { navController.navigate(MovieAppScreen.MovieDetails.name) })
            }
            composable(route = MovieAppScreen.MovieDetails.name) {
                MovieDetailsScreen(movie = uiState.movieAppUiState.detailedMovie, myViewModel = movieViewModel)
            }

        }

    }

//
///**
// * Resets the [OrderUiState] and pops up to [MovieAppScreen.Start]
// */
//private fun cancelOrderAndNavigateToStart(
//    viewModel: MovieViewModel,
//    navController: NavHostController
//) {
//    viewModel.resetOrder()
//    navController.popBackStack(MovieAppScreen.Start.name, inclusive = false)
//}
//
///**
// * Creates an intent to share order details
// */
//private fun shareMovie(context: Context, subject: String, summary: String) {
//    // Create an ACTION_SEND implicit intent with order details in the intent extras
//    val intent = Intent(Intent.ACTION_SEND).apply {
//        type = "text/plain"
//        putExtra(Intent.EXTRA_SUBJECT, subject)
//        putExtra(Intent.EXTRA_TEXT, summary)
//    }
//    context.startActivity(
//        Intent.createChooser(
//            intent,
//            context.getString(R.string.app_name)
//        )
//    )
//}
