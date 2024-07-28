package com.kaizen.caching.roomdb.common.converter

import androidx.room.TypeConverter
import com.kaizen.caching.util.fromJson
import com.kaizen.caching.util.toJson
import java.lang.reflect.Type

/**
 * ObjectConverter is a base class for converting a object in a room database entity
 */
open class ObjectConverter<T>(private val type: Type) {

    @TypeConverter
    open fun mapStringToObject(value: String?): T? {
        return fromJson(value, type)
    }

    @TypeConverter
    open fun mapObjectToString(value: T): String? {
        return toJson(value, type)
    }
}


