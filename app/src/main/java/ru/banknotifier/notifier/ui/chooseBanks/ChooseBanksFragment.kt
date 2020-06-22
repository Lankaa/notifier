package ru.banknotifier.notifier.ui.chooseBanks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_choosebanks.*
import kotlinx.android.synthetic.main.fragment_choosebanks.view.time_in
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.banknotifier.notifier.Bank
import ru.banknotifier.notifier.R
import ru.banknotifier.notifier.connection.ApiGetBanks
import ru.banknotifier.notifier.connection.RetrofitClientInstance

class ChooseBanksFragment : Fragment() {

    private lateinit var root: View
    lateinit var chooseBanksViewModel: ChooseBanksViewModel
    lateinit var bankModel : List<Bank>
    private lateinit var adapter2 : BankRecyclerViewAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_choosebanks, container, false)

        val timeInfoTextView: TextView = root.time_in

        timeInfoTextView.text = getString(R.string.notification_in, "09:00")

        val chooseTimeBtn: Button = root.findViewById(R.id.choose_time_btn)
        chooseTimeBtn.setOnClickListener{
            activity?.supportFragmentManager?.let { view ->
                val timePicker = TimePickerDialogFragment()
                timePicker.show(view, "TimePickerDialogFragment")
            }
        }

        loadBanks()
        viewModelInit()

        return root
    }

    private fun loadBanks() {
        val api = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiGetBanks::class.java)
        val token = "20d274e4b0f7ee6b877f153e6c3099096f6e1dd832db9156931703d75a0e40c7"

        api.fetchAllBanks(token).enqueue(object : Callback<List<Bank>> {

            override fun onResponse(call: Call<List<Bank>>, response: Response<List<Bank>>) {

                bankModel = response.body()!!

                initData(bankModel)
                loadData(bankModel)
            }

            override fun onFailure(call: Call<List<Bank>>, t: Throwable) {
                println("getBanks $call $t It is no ok")
            }
        })
    }

    fun initData(bankModel : List<Bank>){
        banks_list.apply {
            setHasFixedSize(true)
            adapter2 = BankRecyclerViewAdapter(bankModel)
            layoutManager = LinearLayoutManager(root.context)
            adapter = adapter2
        }
    }

    private fun viewModelInit() {
        chooseBanksViewModel = this.run {
            ViewModelProvider(this)[ChooseBanksViewModel::class.java]
        }

        chooseBanksViewModel.getBanks().observe(viewLifecycleOwner, Observer {
            adapter2.setData(bankModel)
            banks_list.adapter!!.notifyDataSetChanged()
        })
    }

    fun loadData(bankModel : List<Bank>) {
        chooseBanksViewModel.setBanks(bankModel)

    }
}