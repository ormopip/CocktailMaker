package com.formacion.cocktailmaker.components

import com.google.gson.Gson
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

class TypeConverter {

    @TypeConverter
    fun fromStringListToJSON(stringlist: List<String>): String {
        return Gson().toJson(stringlist)
    }
    @TypeConverter
    fun fromJSONToString(json: String): List<String> {
        return Gson().fromJson<List<String>>(json) //using extension function
    }

    inline fun <reified T> Gson.fromJson(json: String) =
        fromJson<T>(json, object : TypeToken<T>() {}.type)
}