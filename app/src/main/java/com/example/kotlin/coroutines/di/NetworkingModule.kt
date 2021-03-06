
package com.example.kotlin.coroutines.di

import com.example.kotlin.coroutines.data.api.MovieApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://api.themoviedb.org/"
const val API_KEY = "915c3dd5d1b451734182e63e3c6b7b46"
const val MOVIE_IMAGE_BASE_PATH = "https://image.tmdb.org/t/p/w500"

fun networkingModule() = module {
  single {
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
          level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
  } // client

  single { GsonConverterFactory.create() } // gson converter

  single {
    Retrofit.Builder()
        .addConverterFactory(get<GsonConverterFactory>())
        .client(get<OkHttpClient>())
        .baseUrl(BASE_URL)
        .build()
  } // retrofit

  single { get<Retrofit>().create(MovieApiService::class.java) } // api service
}