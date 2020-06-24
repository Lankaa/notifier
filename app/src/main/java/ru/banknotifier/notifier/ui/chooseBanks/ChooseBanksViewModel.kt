package ru.banknotifier.notifier.ui.chooseBanks

import android.provider.Settings.Global.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.banknotifier.notifier.Bank
import ru.banknotifier.notifier.R

class ChooseBanksViewModel : ViewModel() {

    private val banks = MutableLiveData<List<Bank>>()

    fun setBanks(banksList: List<Bank>){
        banks.value = banksList
    }

    fun getBanks(): LiveData<List<Bank>> {
        return banks
    }

    private val _timeText = MutableLiveData<String>().apply {
        value = ""
    }
    val notificationTimeText: LiveData<String> = _timeText
}