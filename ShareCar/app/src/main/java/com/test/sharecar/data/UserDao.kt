package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM person_table")
    fun getAll(): List<User>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: User)

    @Query ("DELETE FROM person_table")
    suspend fun deleteAll()
}