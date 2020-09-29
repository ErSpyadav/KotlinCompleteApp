
package com.example.kotlin.coroutines.domain.repository

import com.example.kotlin.coroutines.data.api.MovieApiService
import com.example.kotlin.coroutines.data.database.MovieDao
import com.example.kotlin.coroutines.data.model.Movie
import com.example.kotlin.coroutines.data.model.Result
import com.example.kotlin.coroutines.di.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Connects to the end entity, and exposes functionality to the user.
 */
class MovieRepositoryImpl(
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun getMovies(): Result<List<Movie>> = withContext(Dispatchers.IO) {

        val cachedMovies = movieDao.getSavedMovies()

        try {
            val result = movieApiService.getMovies(API_KEY).execute()
            val moviesResponse = result.body()?.movies

            if (result.isSuccessful && moviesResponse != null) {
                Result(moviesResponse, null)
            } else {
                Result(cachedMovies, null)
            }
        } catch (error: Throwable) {
            if (error is IOException && cachedMovies.isEmpty()) {
                Result(null, error)
            } else {
                Result(cachedMovies, null)
            }
        }
    }
}