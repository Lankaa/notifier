package ru.banknotifier.notifier.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notifications.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.banknotifier.notifier.Notification
import ru.banknotifier.notifier.R
import ru.banknotifier.notifier.connection.ApiGetNotifications
import ru.banknotifier.notifier.connection.RetrofitClientInstance
class NotificationsFragment : Fragment() {

    private lateinit var root: View
    lateinit var notificationsViewModel: NotificationsViewModel
    lateinit var notificationModel : List<Notification>
    private lateinit var adapter2 : NotificationsRecyclerViewAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_notifications, container, false)

        loadNotifications()
        viewModelInit()

        return root
    }

    private fun loadNotifications() {
        val api = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiGetNotifications::class.java)
        val token = "20d274e4b0f7ee6b877f153e6c3099096f6e1dd832db9156931703d75a0e40c7"

        api.fetchAllNotifications(token).enqueue(object : Callback<List<Notification>> {

            override fun onResponse(call: Call<List<Notification>>, response: Response<List<Notification>>) {

                notificationModel = response.body()!!
                println(notificationModel)

                initData(notificationModel)
                loadData(notificationModel)
            }

            override fun onFailure(call: Call<List<Notification>>, t: Throwable) {
                println("getNotifications $call $t It is no ok")
            }
        })
    }

    fun initData(notificationModel : List<Notification>){
        notifications_list.apply {
            setHasFixedSize(true)
            adapter2 = NotificationsRecyclerViewAdapter(notificationModel)
            layoutManager = LinearLayoutManager(root.context)
            adapter = adapter2
        }
    }

    private fun viewModelInit() {
        notificationsViewModel = this.run {
            ViewModelProvider(this)[NotificationsViewModel::class.java]
        }

        notificationsViewModel.getNotifications().observe(viewLifecycleOwner, Observer {
            adapter2.setData(notificationModel)
            notifications_list.adapter!!.notifyDataSetChanged()
        })
    }

    fun loadData(notificationModel : List<Notification>) {
        notificationsViewModel.setBanks(notificationModel)

    }
}