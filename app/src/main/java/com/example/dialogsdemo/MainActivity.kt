package com.example.dialogsdemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCustomDialog.setOnClickListener{

            var dialog = CustomDialogFragment()

            dialog.show(supportFragmentManager,"customDialog")

        }

        btnDatePicker.setOnClickListener {

            var formatDate = SimpleDateFormat("dd/MM/YYYY", Locale.US)

            val getDate: Calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(this,android.R.style.Widget_Holo_ActionBar_TabBar,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

               val selectDate : Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR,i)
                selectDate.set(Calendar.MONTH,i2)
                selectDate.set(Calendar.DAY_OF_MONTH,i3)

                val date : String = formatDate.format(selectDate.time)

                tvShow.text = date

            }, getDate.get(Calendar.YEAR),getDate.get(Calendar.MONTH),getDate.get(Calendar.DAY_OF_MONTH))

            datePicker.show()
        }

        btnTimePicker.setOnClickListener {

            val getTime : Calendar = Calendar.getInstance()

            val timeSetListener = TimePickerDialog(this,android.R.style.Widget_Holo_ActionBar, TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->

                val selectTime : Calendar = Calendar.getInstance()
                selectTime.set(Calendar.HOUR_OF_DAY, hour)
                selectTime.set(Calendar.MINUTE, minute)

                val time : String = SimpleDateFormat("HH:mm", Locale.US).format(selectTime.time)

                tvTime.text = time

            }, getTime.get(Calendar.HOUR_OF_DAY),getTime.get(Calendar.MINUTE),true)

            timeSetListener.show()

        }

        btnAlertDialog.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are you sure !")
            builder.setMessage("Do you want to close the app?")
            builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                finish()
            }
            builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }
            builder.show()

        }

    }
}
