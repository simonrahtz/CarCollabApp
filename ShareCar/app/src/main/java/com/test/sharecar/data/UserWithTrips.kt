package com.test.sharecar.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithTrips(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val trips: List<Trip>
)