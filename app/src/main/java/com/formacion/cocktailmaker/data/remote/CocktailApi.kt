package com.formacion.cocktailmaker.data.remote

import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import retrofit2.http.GET
import retrofit2.http.Headers

//www.thecocktaildb.com/api/json/v1/1/list.php?i=list

interface CocktailApi {
    @GET("api/json/v1/1/list.php")
    @Headers("")
    suspend fun getIngredientList(): List<IngredientDto>
}