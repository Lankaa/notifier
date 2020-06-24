package ru.banknotifier.notifier.ui.notifications

import android.annotation.SuppressLint
import android.text.format.DateFormat
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import ru.banknotifier.notifier.Notification
import ru.banknotifier.notifier.R
import java.text.SimpleDateFormat
import java.util.*

class NotificationsRecyclerViewAdapter(
    private var notifications: List<Notification>
) : RecyclerView.Adapter<NotificationsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_notification_item, parent, false)
        return ViewHolder(view)
    }

    fun setData(notificationModel: List<Notification> ) {
        this.notifications = notificationModel
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = notifications[position]
        holder.bankTitle.text = notification.bank.title
        holder.tariffLink.text = notification.fileLink
        holder.date.text = notification.date

        Picasso.get()
            .load(notification.bank.icon)
            .resize(200, 200)
            .centerCrop()
            .into(holder.iconView)

    }

    override fun getItemCount(): Int = notifications.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView = view.findViewById(R.id.bank_icon)
        val bankTitle: TextView = view.findViewById(R.id.bank_title)
        val tariffLink: TextView = view.findViewById(R.id.tariff_link)
        val date: TextView = view.findViewById(R.id.notification_date)
    }
}