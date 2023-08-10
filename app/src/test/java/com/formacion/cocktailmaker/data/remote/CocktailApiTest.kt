package com.formacion.cocktailmaker.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientInfoArrayDto
import com.formacion.cocktailmaker.data.remote.dto.RandomCocktailDto
import com.formacion.cocktailmaker.testutil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Query

@ExperimentalCoroutinesApi
class CocktailApiTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()

    private lateinit var api: CocktailApi

    @Before
    fun setup() {
        api = retrofit.create(CocktailApi::class.java)
    }

    @Test
    fun `WHEN request ingredients list EXPECT result`() = runTest {
        val result = api.getIngredientList("list")
       assertThat(result.ingredients?.isNotEmpty(), CoreMatchers.`is`(true))
    }

    @Test
    fun `WHEN request unkown query EXPECT null`() = runTest {
        val result = api.getIngredientList("nose")
        assertEquals(result, IngredientArrayDto(ingredients=null))
    }


    @Test
    fun `WHEN request random cocktail EXPECT random cocktail`() = runTest {
        val result = api.getRandomCocktail()
        assertThat(result.cocktailList?.isNotEmpty(), CoreMatchers.`is`(true))
    }

    @Test
    fun `WHEN request ingredient detail EXPECT result`() = runTest {
        val result = api.getIngredientDetail("Dark Rum")
        assertThat(result.ingredients?.isNotEmpty(), CoreMatchers.`is`(true))
    }

    @Test
    fun `WHEN request unknown ingredient EXPECT result`() = runTest {
        val result = api.getIngredientDetail("noseque")
        assertEquals(result, IngredientInfoArrayDto(ingredients=null))
    }

    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}