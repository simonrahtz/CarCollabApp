package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM person_table")
    fun getAll(): LiveData<List<User>>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query ("DELETE FROM person_table ")
    suspend fun deleteAll()


}