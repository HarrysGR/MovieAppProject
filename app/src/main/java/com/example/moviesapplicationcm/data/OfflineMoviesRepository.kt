package com.example.moviesapplicationcm.data

import com.example.moviesapplicationcm.model.Movie
import com.example.moviesapplicationcm.model.MovieDbCastResponse
import com.example.moviesapplicationcm.model.MovieDbResponse
import com.example.moviesapplicationcm.model.MovieDetails
import com.example.moviesapplicationcm.model.MovieDetailsResponse
import kotlinx.coroutines.flow.Flow

class OfflineMoviesRepository(private val movieDao: MoviesDao) : MoviesRepository {
    override suspend fun getMoviesList(): MovieDbResponse {
        TODO()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse {
        TODO()
    }

    override suspend fun getCastDetails(id: Int): MovieDbCastResponse {
        TODO("Not yet implemented")
    }

    suspend fun insertMovie(movie: MovieItem) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(id:Int) {
        movieDao.deleteMovie(id)
    }

    suspend fun updateMovie(movie: MovieItem) {
        movieDao.updateMovie(movie)
    }
}