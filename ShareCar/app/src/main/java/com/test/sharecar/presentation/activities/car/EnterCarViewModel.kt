package com.test.sharecar.presentation.activities.car

import androidx.lifecycle.ViewModel
import com.test.sharecar.data.Car
import com.test.sharecar.data.DataCache


class EnterCarViewModel: ViewModel() {

    private var id : Int = 0

    fun createCar(
        regNo: String, make: String, model: String, regDueDate: String
    ) {
        //store user in cache
        DataCache.currentCar[id] = Car(make, model)

        //increment id to keep it unique
        id++
    }

}