package com.test.sharecar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class ShareCarDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    //Singleton principle (Make sure we aren't creating multiple databases)
    companion object{
        @Volatile
        private var INSTANCE: ShareCarDatabase? = null

        //Check to see if database exists
        fun getDatabase(context: Context): ShareCarDatabase{
            val tempInstance = INSTANCE
            //If instance of database exists then just return it
            if(tempInstance != null){
                return tempInstance
            }
            //If it doesn't exist then create a database
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShareCarDatabase::class.java,
                    "car_share_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}