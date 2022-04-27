package com.test.sharecar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1, exportSchema = false)
abstract class ShareCarDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: ShareCarDatabase? = null

        fun getDatabase(context: Context): ShareCarDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                context.applicationContext,
                ShareCarDatabase::class.java,
                "ShareCarDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }


    }
}