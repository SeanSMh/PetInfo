package com.sean.petinfo.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import kotlin.math.sin

/**
 * Author: Sean-Shen
 * Date: 2021/3/31
 * Desc:
 */
@Database(entities = [PetInfoEntity::class], version = 1)
abstract class PetDb : RoomDatabase() {

    abstract fun PetDao(): PetDao   //必须提供这个抽象方法

    companion object {
        @Volatile
        private var sInstance: PetDb? = null
        private const val DATA_BASE_NAME = "pet_info.db"

        @JvmStatic
        fun getInstance(context: Context): PetDb? {
            if(sInstance == null) {
                synchronized(PetDb::class.java) {
                    if(sInstance == null) {
                        return createDb(context)
                    }
                }
            }
            return sInstance
        }

        private fun createDb(context: Context): PetDb {
            return Room.databaseBuilder(context.applicationContext, PetDb::class.java, DATA_BASE_NAME).build()
        }
    }

    override fun clearAllTables() {

    }
}