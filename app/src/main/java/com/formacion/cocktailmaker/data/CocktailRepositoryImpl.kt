package com.formacion.cocktailmaker.data

import com.formacion.cocktailmaker.DataBuilders.CocktailModelDataBuilder
import com.formacion.cocktailmaker.DataBuilders.IngredientInfoDataBuilder
import com.formacion.cocktailmaker.data.local.LocalDataSource
import com.formacion.cocktailmaker.data.mappers.toCocktailLocal
import com.formacion.cocktailmaker.data.mappers.toCocktailModel
import com.formacion.cocktailmaker.data.mappers.toIngredientInfoModel
import com.formacion.cocktailmaker.data.mappers.toIngredientModel
import com.formacion.cocktailmaker.data.remote.RemoteDataSource
import com.formacion.cocktailmaker.domain.model.CocktailModel
import com.formacion.cocktailmaker.domain.model.IngredientInfoModel
import com.formacion.cocktailmaker.domain.model.IngredientModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CocktailRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : CocktailRepository {
    override suspend fun getIngredientList(): Flow<List<IngredientModel>> {
        return remoteDataSource.getIngredientList().map {
            it?.ingredients?.map { ingredient ->
                ingredient.toIngredientModel()
            } ?: listOf(IngredientModel("sdfsdf"))
        }
    }

    override suspend fun getRandomCocktail(): Flow<CocktailModel> {
        return remoteDataSource.getRandomCocktail().map {
            it?.cocktailList?.first()?.toCocktailModel()?: CocktailModelDataBuilder().buildSingle()
            }
        }

    override suspend fun getFavorites(): Flow<List<CocktailModel>> {
        return localDataSource.getFavorites().map { cocktailList ->
            cocktailList.map {
                it.toCocktailModel()
            }
        }
    }

    override suspend fun insertFavorite(cocktailModel: CocktailModel) {
        localDataSource.insertCocktail(cocktailModel.toCocktailLocal())
    }

    override suspend fun deleteFavorite(cocktailModel: CocktailModel) {
        localDataSource.deleteFavorite(cocktailModel.toCocktailLocal())
    }

    override suspend fun getIngredientInfo(name: String): Flow<IngredientInfoModel> {
        return remoteDataSource.getIngredientInfo(name).map {
                it?.ingredients?.first()?.toIngredientInfoModel()?:IngredientInfoDataBuilder().buildSingle()
        }
    }
}




