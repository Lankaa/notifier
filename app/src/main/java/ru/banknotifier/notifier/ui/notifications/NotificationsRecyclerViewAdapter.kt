package ru.banknotifier.notifier.ui.notifications

import android.annotation.SuppressLint
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.squareup.picasso.Picasso
import ru.banknotifier.notifier.Notification
import ru.banknotifier.notifier.R
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

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

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = notifications[position]
        holder.bankTitle.text = notification.bank.title
        holder.tariffLink.text = notification.fileLink

        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val dateFromString = ZonedDateTime.parse(notification.date)
        holder.date.text = dateFromString.format(formatter)

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