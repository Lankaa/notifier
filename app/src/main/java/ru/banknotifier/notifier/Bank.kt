package ru.banknotifier.notifier

data class Bank(
    val id: Int,
    val icon: String,
    val title: String,
    val isSelected: Boolean
)