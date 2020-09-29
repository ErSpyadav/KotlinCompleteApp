
package com.example.kotlin.coroutines.ui.movies

interface MoviesPresenter {

  fun setView(moviesView: MoviesView)

  fun getData()
}
