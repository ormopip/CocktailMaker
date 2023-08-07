package com.formacion.cocktailmaker.di

import com.formacion.cocktailmaker.data.CocktailRepository
import com.formacion.cocktailmaker.data.CocktailRepositoryImpl
import com.formacion.cocktailmaker.data.remote.CocktailApi
import com.formacion.cocktailmaker.data.remote.RemoteDataSource
import com.formacion.cocktailmaker.data.remote.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            //.baseUrl("https://dragonball.keepcoding.education/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<CocktailRepository> { CocktailRepositoryImpl(get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<CocktailApi> {
        getCocktailApi(get())
    }

}

private fun getCocktailApi(retrofit: Retrofit) =
    retrofit.create(CocktailApi::class.java)
