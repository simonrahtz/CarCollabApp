package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    //@Query( "SELECT * FROM user_table where name = :name")
    //suspend fun getUserByName(name: String): LiveData<User>

    @Query("SELECT * FROM user_table")
    fun readAllData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrip(trip: Trip)

    @Query("select * from user_table ORDER by ROWID desc limit 1")
    fun getLatestEntry(): LiveData<User>

    @Transaction
    @Query("Select * from user_table where userId = :userId")
    suspend fun getUserWithTrips(userId: String): UserWithTrips
}