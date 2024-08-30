package com.example.moviesapplicationcm.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviesapplicationcm.R
import com.example.moviesapplicationcm.model.Movie
import com.example.moviesapplicationcm.ui.MovieViewModel
import com.example.moviesapplicationcm.ui.theme.MoviesApplicationCMTheme
import com.example.moviesapplicationcm.ui.theme.White


@Composable
fun MovieDetailsPopUp(movie: Movie, myViewModel: MovieViewModel, onDetailsPressed: ()->Unit) {
    Card(
        modifier = Modifier.size(width = 345.dp, height = 249.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.surface),
        colors = CardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f), contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContentColor = MaterialTheme.colorScheme.surface, disabledContainerColor = MaterialTheme.colorScheme.onSurface),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation( 5.dp)
    ) {
        val heartPainter = if (movie.isFavourite) {
            painterResource(id = R.drawable.heart_full)
        } else {
            painterResource(id = R.drawable.heart_off)
        }
        val heartStringResource = if (movie.isFavourite) {
            stringResource(id = R.string.favourite)
        } else {
            stringResource(id = R.string.not_favourite)
        }
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            Row (modifier = Modifier
                .fillMaxWidth()
                .height(24.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Text(text = movie.title,modifier = Modifier.width(235.dp), overflow = TextOverflow.Ellipsis , color = MaterialTheme.colorScheme.onSurface,fontSize = 20.sp  , fontWeight = FontWeight(700), lineHeight = 24.2.sp)
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick ={/*send heart true/false */} ,modifier = Modifier.size(24.dp),) {
                    Icon(painter = heartPainter, contentDescription = heartStringResource ,
                        tint = MaterialTheme.colorScheme.primary)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick ={myViewModel.closePopUp()} ,modifier = Modifier.size(24.dp),) {
                    Icon(painter = painterResource(id = R.drawable.close), contentDescription = null ,
                        tint = MaterialTheme.colorScheme.onBackground)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row (modifier = Modifier
                .width(313.dp)
                .height(152.dp)) {
                AsyncImage(
                    model = movie.posterPath,
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(152.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        ),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier
                            .width(188.dp)
                            .height(16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = stringResource(id = R.string.star),
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = movie.rating,
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            lineHeight = 14.52.sp,
                            letterSpacing = 0.12.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "(3232)",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            lineHeight = 14.52.sp,
                            letterSpacing = 0.12.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            modifier = Modifier
                                .width(52.46.dp)
                                .height(18.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.calendarblank),
                                contentDescription = stringResource(id = R.string.calendar),
                                modifier = Modifier.size(16.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = movie.releaseDate,
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 14.52.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = movie.overview,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 14.52.sp,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Left,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = {onDetailsPressed()},
                colors = ButtonColors(containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary, disabledContainerColor = White, disabledContentColor = White),
                modifier = Modifier
                    .width(110.dp)
                    .height(25.dp),
                contentPadding = PaddingValues(0.dp),

                ) {
                Text(text = stringResource(id = R.string.details), textAlign = TextAlign.Center ,modifier = Modifier.width(78.dp), lineHeight = 17.sp, fontSize = 14.sp, fontWeight = FontWeight(400))
            }
        }
    }
}

@Composable
fun LogInInfoPopUp(movie: Movie) {
    Card(
        modifier = Modifier.size(width = 345.dp, height = 108.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.surface),
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContentColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(6.dp),
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            Row(modifier = Modifier
                .height(26.1.dp)
                .width(313.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_pic_emtpy),
                    contentDescription = stringResource(id = R.string.profile_picture),
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .border(
                            BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
                            CircleShape
                        )
                        .size(26.1.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Long Username",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 19.36.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {/*send heart true/false */ },
                    modifier = Modifier.size(24.dp),) {
                    Icon(
                        painter = painterResource(id = R.drawable.close), contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            TextButton(onClick = {/*Go to details Page */},
                colors = ButtonColors(containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary, disabledContainerColor = White, disabledContentColor = White),
                modifier = Modifier
                    .width(119.dp)
                    .height(25.dp),
                contentPadding = PaddingValues(0.dp),

                ) {
                Text(text = stringResource(id = R.string.sign_out), textAlign = TextAlign.Center ,modifier = Modifier.width(78.dp), lineHeight = 17.sp, fontSize = 14.sp, fontWeight = FontWeight(400))
            }
        }
    }
}

@Preview
@Composable
fun PreviewMovieDetailsPopUp() {
    MoviesApplicationCMTheme {
//        MovieListScreen(detailsPanel = true)
    }
}
@Preview
@Composable
fun PreviewLoginInfoPopUp() {
//    MovieListScreen(loginInfoPanel = true)
}