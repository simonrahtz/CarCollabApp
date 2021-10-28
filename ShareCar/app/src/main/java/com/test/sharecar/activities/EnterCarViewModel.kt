package com.test.sharecar.activities

import androidx.lifecycle.ViewModel
import com.test.sharecar.DataCache
import com.test.sharecar.models.Car

class EnterCarViewModel: ViewModel() {

    private var id : Int = 0

    fun createCar(
        regNo: String, make: String, model: String, regDueDate: String
    ) {
        //store user in cache
        DataCache.currentCar[id] = Car(id, regNo, make, model, regDueDate)

        //increment id to keep it unique
        id++
    }

}