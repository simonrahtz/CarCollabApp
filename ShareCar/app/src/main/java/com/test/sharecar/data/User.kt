package com.test.sharecar.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("userId")
    var userId: Int = 0
    @ColumnInfo("name")
    var name: String = ""
    @ColumnInfo("email")
    var email: String = ""
    @ColumnInfo("phoneNo")
    var phoneNo: String = ""
    @ColumnInfo("address")
    var address: String = ""
    @ColumnInfo("password")
    var password: String = ""


    constructor()

    constructor(id: Int, name: String, email: String, phone: String, address: String){
        this.userId = id
        this.email = email
        this.name = name
        this.phoneNo = phone
        this.address = address
    }



}



