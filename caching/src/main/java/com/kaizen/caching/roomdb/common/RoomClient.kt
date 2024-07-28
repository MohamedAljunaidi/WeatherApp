package com.kaizen.caching.roomdb.common

import android.content.Context
import androidx.room.Room

object RoomClient {

    fun createDatabaseRoom(
        context:Context
    ): DatabaseRoom {
        return  Room
            .databaseBuilder(context, DatabaseRoom::class.java, RoomConstants.DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }

}