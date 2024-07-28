package com.kaizen.caching.roomdb.common.converter

import com.kaizen.caching.util.type

/**
 * StringDataConverter is a base class for converting a list of String in a room database entity
 */
class StringDataConverter :
    ListConverter<String>(type<List<String>>())