package com.formacion.cocktailmaker.data.mappers

import com.formacion.cocktailmaker.DataBuilders.CocktailLocalDataBuilder
import com.formacion.cocktailmaker.DataBuilders.CocktailModelDataBuilder
import com.formacion.cocktailmaker.DataBuilders.IngredientInfoDtoDataBuilder
import com.formacion.cocktailmaker.DataBuilders.RandomCocktailDtoDataBuilder
import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CocktailDtoMapperTest {

    @Test
    fun `WHEN toIngredientModel with values EXPECT model has value`() {
        val ingredientDto = IngredientDto(
            id = "test-id",
        )
        val res = ingredientDto.toIngredientModel()
        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toIngredientModel with null EXPECT empty string`() {
        val ingredientDto = IngredientDto(
            id = null,
        )
        val res = ingredientDto.toIngredientModel()
        assertThat(res.id, `is`(""))
    }

    @Test
    fun `WHEN toCocktailModel with values EXPECT model has value`(){
        val randomCocktailDto = RandomCocktailDtoDataBuilder().buildSingle()
        val res = randomCocktailDto.toCocktailModel()
        assertThat(res.id, `is`("test-cocktail-dto"))
    }

    @Test
    fun `WHEN toCocktailModel with null EXPECT empty string`(){
        val randomCocktailDto = RandomCocktailDtoDataBuilder()
            .withName(null)
            .buildSingle()
        val res = randomCocktailDto.toCocktailModel()
        assertThat(res.name, `is`(""))
    }

    @Test
    fun `WHEN toIngredientInfoModel with values EXPECT model has value`(){
        val ingredientInfoDto = IngredientInfoDtoDataBuilder().buildSingle()
        val res = ingredientInfoDto.toIngredientInfoModel()
        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toIngredientInfoModel with null EXPECT empty string`(){
        val ingredientInfoDto = IngredientInfoDtoDataBuilder()
            .withName(null)
            .buildSingle()
        val res = ingredientInfoDto.toIngredientInfoModel()
        assertThat(res.name, `is`(""))
    }

    @Test
    fun `WHEN toCocktailModel FROM CocktailLocal with values EXPECT model has value`(){
        val cocktailLocal = CocktailLocalDataBuilder().buildSingle()
        val res = cocktailLocal.toCocktailModel()
        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toCocktailLocal with values EXPECT model has value`() {
        val cocktailModel = CocktailModelDataBuilder().buildSingle()
        val res = cocktailModel.toCocktailLocal()
        assertThat(res.id, `is`("test-id"))
    }


}