package com.formacion.cocktailmaker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.formacion.cocktailmaker.data.local.model.CocktailLocal

@Database(entities = [CocktailLocal::class], version = 1, exportSchema = false)
abstract class CocktailDatabase: RoomDatabase(){
    abstract fun cocktailDao(): CocktailDao
}