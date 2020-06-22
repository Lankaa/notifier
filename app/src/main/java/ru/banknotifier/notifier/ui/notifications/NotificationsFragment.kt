package ru.banknotifier.notifier.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import ru.banknotifier.notifier.NotificationsDummy
import ru.banknotifier.notifier.R

class NotificationsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        val notificationsListView: RecyclerView = root.notifications_list
        notificationsListView.setHasFixedSize(true)
        notificationsListView.layoutManager = LinearLayoutManager(root.context)
        notificationsListView.adapter = NotificationsRecyclerViewAdapter(NotificationsDummy.ITEMS)

        return root
    }
}