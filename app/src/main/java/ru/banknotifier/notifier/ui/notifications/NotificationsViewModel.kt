package ru.banknotifier.notifier.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.banknotifier.notifier.Notification

class NotificationsViewModel : ViewModel() {

    private val notifications = MutableLiveData<List<Notification>>()

    fun setBanks(notificationsList: List<Notification>){
        notifications.value = notificationsList
    }

    fun getNotifications(): LiveData<List<Notification>> {
        return notifications
    }
}