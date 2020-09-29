
package com.example.kotlin.coroutines.di

import com.example.kotlin.coroutines.ui.movies.MoviesPresenter
import com.example.kotlin.coroutines.ui.movies.MoviesPresenterImpl
import org.koin.dsl.module

/**
 * Creates presenters for the app.
 */

fun presenterModule() = module {
  single { MoviesPresenterImpl(get()) as MoviesPresenter }
}