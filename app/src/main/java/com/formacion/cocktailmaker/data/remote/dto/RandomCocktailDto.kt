package com.formacion.cocktailmaker.data.remote.dto

import com.squareup.moshi.Json

data class RandomCocktailDto(
    @Json(name="idDrink") val id:String?,
    @Json(name="strDrink") val name:String?,
    @Json(name="strCategory") val category:String?,
    @Json(name="strAlcoholic") val alcoholic:String?,
    @Json(name="strGlass") val glass:String?,
    @Json(name="strInstructions") val instructions:String?,
    @Json(name="strDrinkThumb") val photoUrl:String?,
    @Json(name="strIngredient1") val ingredient1:String?,
    @Json(name="strIngredient2") val ingredient2:String?,
    @Json(name="strIngredient3") val ingredient3:String?,
    @Json(name="strIngredient4") val ingredient4:String?,
    @Json(name="strIngredient5") val ingredient5:String?,
    @Json(name="strIngredient6") val ingredient6:String?,
    @Json(name="strIngredient7") val ingredient7:String?,
    @Json(name="strIngredient8") val ingredient8:String?,
    @Json(name="strMeasure1") val measure1:String?,
    @Json(name="strMeasure2") val measure2:String?,
    @Json(name="strMeasure3") val measure3:String?,
    @Json(name="strMeasure4") val measure4:String?,
    @Json(name="strMeasure5") val measure5:String?,
    @Json(name="strMeasure6") val measure6:String?,
    @Json(name="strMeasure7") val measure7:String?,
    @Json(name="strMeasure8") val measure8:String?,


)