package ru.banknotifier.notifier.ui.chooseBanks

import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import ru.banknotifier.notifier.R
import java.text.SimpleDateFormat
import java.util.*

class TimePickerDialogFragment: DialogFragment() {
    private lateinit var time_in: TextView
    override fun onCreateDialog(savedInstanceState: Bundle?): TimePickerDialog {
        time_in = activity?.findViewById(R.id.time_in)!!
        return activity?.let {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener{
                    timePicker, hour, minute ->
                run {
                    c.set(Calendar.HOUR_OF_DAY, hour)
                    c.set(Calendar.MINUTE, minute)
                    val time = SimpleDateFormat("HH:mm").format(c.time);
                    time_in.let {
                        time_in.text = getString(R.string.notification_in, time)
                    }
                }
            }

             val picker = TimePickerDialog(
                activity,
                3,
                listener,
                hour,
                minute,
                true
            )
            picker.setTitle(R.string.choose_time)
            picker.setMessage(resources.getString(R.string.time_info))
            picker.setButton(
                DialogInterface.BUTTON_POSITIVE,
                resources.getString(R.string.ok)
            ) { dialog, which ->  if(which == DialogInterface.BUTTON_POSITIVE) {
                picker.updateTime(hour, minute)
            } }
            picker.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                resources.getString(R.string.cancel)
            ) { dialog, which ->  if(which == DialogInterface.BUTTON_NEGATIVE) {
                picker.dismiss()
            } }

            return picker
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}


