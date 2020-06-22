package ru.banknotifier.notifier

data class Notification (
    val id: Int,
    val bank: Bank,
    val dateCreate: String,
    val fileLink: String
)