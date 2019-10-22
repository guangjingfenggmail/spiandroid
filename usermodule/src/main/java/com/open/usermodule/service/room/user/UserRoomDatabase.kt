package com.open.usermodule.service.room.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-10-22.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 */

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO

    private class UserDatabaseCallback internal constructor(internal var scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO) {
                    it.userDao()
                }
            }
        }
    }

    companion object {

        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserRoomDatabase {
            val database = INSTANCE
            if (database != null)
                return database

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                        UserRoomDatabase::class.java,
                        "user_database")
                        .addCallback(UserDatabaseCallback(scope))
                        .build()

                INSTANCE = instance
                return instance
            }

        }
    }
}

