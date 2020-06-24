package ru.banknotifier.notifier.ui.chooseBanks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.banknotifier.notifier.Bank
import ru.banknotifier.notifier.R
import ru.banknotifier.notifier.connection.ApiPutBank
import ru.banknotifier.notifier.connection.RetrofitClientInstance


class BankRecyclerViewAdapter(
    private var banks: List<Bank>
) : RecyclerView.Adapter<BankRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_bank_item, parent, false)
        return ViewHolder(view)
    }

    fun setData(bankModel: List<Bank> ) {
        this.banks = bankModel
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bank = banks[position]
        holder.bankCheckbox.text = bank.title
        holder.bankCheckbox.isChecked = bank.isSelected
        holder.bankCheckbox.setOnClickListener { _ ->
            putBank(bank)
        }

        Picasso.get()
            .load(bank.icon)
            .resize(200, 200)
            .centerCrop()
            .into(holder.iconView)

    }

    override fun getItemCount(): Int = banks.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView = view.findViewById(R.id.bank_icon)
        val bankCheckbox: CheckBox = view.findViewById(R.id.bank_checkbox)
    }

    private fun putBank(bank: Bank) {
        val api = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiPutBank::class.java)
        val token = "20d274e4b0f7ee6b877f153e6c3099096f6e1dd832db9156931703d75a0e40c7"

        val (title, icon, isSelected, id, notifications) = bank

        val updateBank = Bank(title, icon, !isSelected, id, notifications)

        api.changeBank(id, token, updateBank).enqueue(object : Callback<Bank> {

            override fun onResponse(call: Call<Bank>, response: Response<Bank>) {
//                       bankModel = response.body()!!
                println(response.body())
            }

            override fun onFailure(call: Call<Bank>, t: Throwable) {
                println("putBank $call $t It is no ok")
            }
        })
    }
}