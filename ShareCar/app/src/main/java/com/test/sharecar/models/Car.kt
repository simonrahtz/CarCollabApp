package com.test.sharecar.models

import java.util.*

class Car(var id : Int,
          var regNo: String,
            var make: String,
            var model : String,
            private var regDueDate : String) {

            var regAmount = 150
            var totalCostDue = 0


            fun setNextRegDueDate(date : String) {

                this.regDueDate = date

            }

            fun getNextRegDueDate() : String{
                return regDueDate
            }
}