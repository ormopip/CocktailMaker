package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientInfoArrayDto
import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailArrayDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("list.php")
    suspend fun getIngredientList(@Query("i") query: String): IngredientArrayDto

    @GET("random.php")
    suspend fun getRandomCocktail(): RandomCocktailArrayDto

    @GET("search.php")
    suspend fun getIngredientDetail(@Query("i") query: String): IngredientInfoArrayDto

}