package com.test.sharecar.presentation


import android.app.Application
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.lifecycle.*
import com.test.sharecar.data.ShareCarDatabase
import com.test.sharecar.data.Trip
import com.test.sharecar.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class DateTimePickerViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val db = ShareCarDatabase.getDatabase(application)
        val userDao = db.userDao()
        val tripDao = db.tripDao()
        repository = UserRepository(userDao,tripDao)
    }

    private val _time = MutableLiveData("")
    var time: LiveData<String> = _time

    fun selectDateTime(context: Context) {
        var time: String = ""
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)

        DatePickerDialog(context, { _, year, month, day ->
            TimePickerDialog(context, { _, hour, minute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(year, month, day, hour, minute)
                val monthStr: String
                if ((month + 1).toString().length == 1) {
                    monthStr = "0${month + 1}"
                } else {
                    monthStr = month.toString()
                }
                time = "$day - $monthStr - $year $hour:$minute"
                updateDateTime(time)
            }, startHour, startMinute, false).show()
        }, startYear, startMonth, startDay).show()
    }

    private fun updateDateTime(dateTime: String) {
        _time.value = dateTime
    }

    fun insertTrip(trip: Trip){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTrip(trip)
        }
    }
}

