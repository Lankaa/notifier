package ru.banknotifier.notifier

data class Bank(
    val id: Int,
    val icon: String,
    val title: String,
    val isSelected: Boolean,
    val notifications: List<NotificationID>
)

data class NotificationID(val id: Int)

data class BankWithoutID(
    val icon: String,
    val title: String,
    val isSelected: Boolean,
    val notifications: List<NotificationID>
)