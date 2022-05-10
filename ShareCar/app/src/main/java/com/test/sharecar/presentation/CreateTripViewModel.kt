package com.test.sharecar.presentation


import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import androidx.lifecycle.*
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.Trip
import com.test.sharecar.data.ShareCarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class CreateTripViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ShareCarRepository

    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = ShareCarRepository(userDao, tripDao)
    }

    private val _time = MutableLiveData("")
    var time: LiveData<String> = _time

    fun selectDateTime(context: Context) {
        var date: String = ""
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)

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

    fun insertTrip(trip: Trip) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTrip(trip)
        }
    }
}

