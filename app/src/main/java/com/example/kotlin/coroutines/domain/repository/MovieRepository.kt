
package com.example.kotlin.coroutines.domain.repository

import com.example.kotlin.coroutines.data.model.Movie
import com.example.kotlin.coroutines.data.model.Result

/**
 * Interface used to communicate to the end entities, when fetching data.
 */
interface MovieRepository {

  suspend fun getMovies(): Result<List<Movie>>
}