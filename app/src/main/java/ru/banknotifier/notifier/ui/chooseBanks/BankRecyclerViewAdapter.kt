package ru.banknotifier.notifier.ui.chooseBanks

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import ru.banknotifier.notifier.Bank
import ru.banknotifier.notifier.R

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
//        holder.iconView.setImageResource(item.icon)
        holder.bank.text = bank.title
        holder.bank.isChecked = bank.isSelected
    }

    override fun getItemCount(): Int = banks.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView = view.findViewById(R.id.bank_icon)
        val bank: CheckBox = view.findViewById(R.id.bank_checkbox)
    }
}