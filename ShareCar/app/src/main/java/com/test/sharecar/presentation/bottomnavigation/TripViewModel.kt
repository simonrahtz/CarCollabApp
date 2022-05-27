package com.test.sharecar.presentation.bottomnavigation


import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import androidx.lifecycle.*
import com.test.sharecar.CustomGeoCoder
import com.test.sharecar.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class TripViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ShareCarRepository
    private val _time = MutableLiveData("")
    private val fuelPrice = 176.70f //cents
    var time: LiveData<String> = _time
    //var currentUser: LiveData<User>


    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao, tripDao)

        //currentUser =  repository.getCurrentUser()
    }

    fun selectDateTime(context: Context) {
        var date: String = ""
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(context, { _, year, month, day ->
            val pickedDateTime = Calendar.getInstance()
            pickedDateTime.set(year, month, day)
            val monthStr: String = if ((month + 1).toString().length == 1) {
                "0${month + 1}"
            } else {
                month.toString()
            }
            date = "$day/$monthStr/$year"
            updateDateTime(date)
        }, startYear, startMonth, startDay).show()
    }

    private fun updateDateTime(dateTime: String) {
        _time.value = dateTime
    }

    fun storeTrip(address: String, date: String, context: Context) {
        val distance = calculateDistance(address, context)
        val cost = calculateCost(distance)
        val trip =
            Trip(0, date, address, String.format("%.2f", distance), String.format("%.2f", cost))
        insertTrip(trip)
    }

    private fun calculateDistance(address: String, context: Context): Float {
        val start = Car().address
        return CustomGeoCoder(context).getDistance(start, address)
    }

    private fun insertTrip(trip: Trip) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTrip(trip)
        }
    }

    private fun calculateCost(distance: Float): Float {
        val fuelConsumption = Car().fuelPer100km
        val litres = (distance / 100) * fuelConsumption
        //cost of trip, multiply by 2 for there and back
        return ((litres * fuelPrice) / 100) * 2

    }
}

