package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    //@Query( "SELECT * FROM user_table where name = :name")
    //suspend fun getUserByName(name: String): LiveData<User>

    @Query("SELECT * FROM user_table")
    fun readAllData(): LiveData<List<User>>
}