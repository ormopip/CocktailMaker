package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailArrayDto
import retrofit2.http.GET
import retrofit2.http.Query

//www.thecocktaildb.com/api/json/v1/1/list.php?i=list

interface CocktailApi {

    @GET("list.php")
    suspend fun getIngredientList(@Query("i") query: String): IngredientArrayDto

    @GET("random.php")
    suspend fun getRandomCocktail(): RandomCocktailArrayDto

  /*  @GET("list.php")
    suspend fun getIngredientList(@Query("i") query: String): IngredientArrayDto*/

/*    @POST("api/heros/all")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getIngredientList(@Body searchDto: SearchDto): List<IngredientDto>*/
}