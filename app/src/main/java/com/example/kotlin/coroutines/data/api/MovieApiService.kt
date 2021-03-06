
package com.example.kotlin.coroutines.data.api

import com.example.kotlin.coroutines.data.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used to fetch select movies from the Api.
 */
interface MovieApiService {

  @GET("/3/movie/popular")
  fun getMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>
}