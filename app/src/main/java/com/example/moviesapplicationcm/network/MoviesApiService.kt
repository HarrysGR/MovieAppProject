package com.example.moviesapplicationcm.network

import com.example.moviesapplicationcm.model.Movie
import com.example.moviesapplicationcm.model.MovieDbResponse
import com.example.moviesapplicationcm.model.MovieDetails
import retrofit2.http.GET
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.http.Header
import retrofit2.http.Query

interface MoviesApiService {
        @GET("movie/popular")
        suspend fun getMovies(
                @Header("accept") accept: String = "application/json",
                @Header("Authorization") authToken: String,
                @Query("language") language: String = "en-US",
                @Query("page") page: Int = 1
        ): MovieDbResponse

        @GET("movie")
        suspend fun getMovie(): Flow<Movie>
}

