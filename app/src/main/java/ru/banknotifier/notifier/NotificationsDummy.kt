package ru.banknotifier.notifier

import android.graphics.drawable.Icon
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object NotificationsDummy {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<NotificationItem> = ArrayList()
//
//    /**
//     * A map of sample (dummy) items, by ID.
//     */
//    private val ITEM_MAP: MutableMap<String, BankItem> = HashMap()

    private const val bankIcon: Int =  R.drawable.ic_bank_24
    private const val COUNT = 18

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: NotificationItem) {
        ITEMS.add(item)
    }

    private fun createDummyItem(position: Int): NotificationItem {

        return NotificationItem(bankIcon, "Банк $position", "http://bank-notifier.ru/", "12.12.2020")
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class NotificationItem(val icon: Int, val bankTitle: String, val link: String, val date: String) {
        override fun toString(): String = bankTitle
    }
}