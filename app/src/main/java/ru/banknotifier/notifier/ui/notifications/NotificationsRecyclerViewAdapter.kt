package ru.banknotifier.notifier.ui.notifications

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.banknotifier.notifier.NotificationsDummy
import ru.banknotifier.notifier.R

class NotificationsRecyclerViewAdapter(
    private val values: List<NotificationsDummy.NotificationItem>
) : RecyclerView.Adapter<NotificationsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_notification_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.iconView.setImageResource(item.icon)
        holder.iconView.setColorFilter(Color.BLACK)
        holder.bankTitle.text = item.bankTitle
        holder.tariffLink.text = item.link
        holder.date.text = item.date
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView = view.findViewById(R.id.bank_icon)
        val bankTitle: TextView = view.findViewById(R.id.bank_title)
        val tariffLink: TextView = view.findViewById(R.id.tariff_link)
        val date: TextView = view.findViewById(R.id.notification_date)
    }
}