package com.formacion.cocktailmaker.di

import android.content.Context
import androidx.room.Room
import com.formacion.cocktailmaker.data.CocktailRepository
import com.formacion.cocktailmaker.data.CocktailRepositoryImpl
import com.formacion.cocktailmaker.data.local.CocktailDao
import com.formacion.cocktailmaker.data.local.CocktailDatabase
import com.formacion.cocktailmaker.data.local.LocalDataSource
import com.formacion.cocktailmaker.data.local.LocalDataSourceImpl
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
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<CocktailRepository> { CocktailRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<CocktailApi> {
        getCocktailApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesCocktailDao(get())
    }
}

private fun getCocktailApi(retrofit: Retrofit) =
    retrofit.create(CocktailApi::class.java)

private fun getDatabase(context: Context) : CocktailDatabase =
    Room.databaseBuilder(
        context,
        CocktailDatabase::class.java, "cocktail-db"
    ).build()

private fun providesCocktailDao(db: CocktailDatabase) : CocktailDao =
    db.cocktailDao()
