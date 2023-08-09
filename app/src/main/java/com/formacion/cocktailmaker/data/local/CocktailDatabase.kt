package com.formacion.cocktailmaker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.formacion.cocktailmaker.components.TypeConverter
import com.formacion.cocktailmaker.data.local.model.CocktailLocal

@TypeConverters(TypeConverter::class)
@Database(entities = [CocktailLocal::class], version = 1, exportSchema = false)
abstract class CocktailDatabase: RoomDatabase(){
    abstract fun cocktailDao(): CocktailDao
}