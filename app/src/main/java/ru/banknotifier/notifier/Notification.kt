package ru.banknotifier.notifier

data class Notification (
    val id: Int,
    val bank: Bank,
    val date: String,
    val fileLink: String
)

data class NotificationWithoutID (
    val bank: Bank,
    val date: String,
    val fileLink: String
)