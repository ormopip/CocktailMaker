package com.formacion.cocktailmaker.data.local

import com.formacion.cocktailmaker.data.local.model.CocktailLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(
    private val cocktailDao: CocktailDao
): LocalDataSource{
    override suspend fun insertCocktail(cocktail: CocktailLocal) = cocktailDao.insert(cocktail)
    override suspend fun getFavorites(): Flow<List<CocktailLocal>> = flow {
        emit(cocktailDao.getFavorites())
    }
    override suspend fun deleteFavorite(cocktail: CocktailLocal) = cocktailDao.delete(cocktail)

}