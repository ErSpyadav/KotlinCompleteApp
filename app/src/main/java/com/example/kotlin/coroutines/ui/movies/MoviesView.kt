package com.example.kotlin.coroutines.ui.movies

import com.example.kotlin.coroutines.data.model.Movie

/**
 *
 */
interface MoviesView {

  fun showMovies(movies: List<Movie>)

  fun showError(throwable: Throwable)
}