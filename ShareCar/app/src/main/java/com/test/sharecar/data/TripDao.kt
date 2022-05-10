package com.test.sharecar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TripDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrip(trip: Trip)

    @Query("SELECT * FROM trip_table")
    fun readAllData(): LiveData<List<Trip>>

    @Query("select * from trip_table ORDER by ROWID desc limit 1")
    fun getLatestEntry(): LiveData<Trip>
}