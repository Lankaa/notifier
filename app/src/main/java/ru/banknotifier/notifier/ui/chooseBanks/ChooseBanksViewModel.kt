package ru.banknotifier.notifier.ui.chooseBanks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.banknotifier.notifier.Bank

class ChooseBanksViewModel : ViewModel() {

    private val banks = MutableLiveData<List<Bank>>()

    fun setBanks(banksList: List<Bank>){
        banks.value = banksList
        println(banksList)
    }

    fun getBanks(): LiveData<List<Bank>> {
        return banks
    }
}