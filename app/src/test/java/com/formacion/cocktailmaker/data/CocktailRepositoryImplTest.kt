package com.formacion.cocktailmaker.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.formacion.cocktailmaker.DataBuilders.CocktailLocalDataBuilder
import com.formacion.cocktailmaker.data.local.LocalDataSource
import com.formacion.cocktailmaker.data.local.model.CocktailLocal
import com.formacion.cocktailmaker.data.remote.RemoteDataSource
import com.formacion.cocktailmaker.data.remote.dto.IngredientArrayDto
import com.formacion.cocktailmaker.data.remote.dto.IngredientDto
import com.formacion.cocktailmaker.domain.model.IngredientModel
import com.formacion.cocktailmaker.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CocktailRepositoryImplTest {

    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getHeroList EXPECT local data`() = runTest {
        coEvery { localDataSource.getFavorites() } returns flow {
            emit(getListFavoritesLocal())
        }

        val repo = CocktailRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getFavorites()

        MatcherAssert.assertThat(res.count(), CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getHeroList EXPECT remote data`() = runTest {
        coEvery { remoteDataSource.getIngredientList() } returns flow {
            emit(getIngredientList())
        }


        val repo = CocktailRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getIngredientList()

        MatcherAssert.assertThat(res.count(), CoreMatchers.`is`(1))
    }

}

fun getListFavoritesLocal() = listOf(
    CocktailLocalDataBuilder().buildSingle(),
)

fun getIngredientList() = IngredientArrayDto(listOf(IngredientDto("id-test")))


