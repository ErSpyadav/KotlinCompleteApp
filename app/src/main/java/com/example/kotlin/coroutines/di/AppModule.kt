
package com.example.kotlin.coroutines.di

import com.example.kotlin.coroutines.data.database.MovieDatabase
import com.example.kotlin.coroutines.domain.repository.MovieRepository
import com.example.kotlin.coroutines.domain.repository.MovieRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun appModule() = module {

  single { MovieDatabase.create(androidContext()) } // database

  single { get<MovieDatabase>().movieDao() } // dao

  single { MovieRepositoryImpl(get(), get()) as MovieRepository } // repository
}