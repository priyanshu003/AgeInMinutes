package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import calculator.DateCalculator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener { view ->
            datepicker(view)
            Toast.makeText(this,"btn clicked", Toast.LENGTH_SHORT).show()
        }

    }

    private fun datepicker(view: View) {
        val myClaender = Calendar.getInstance()
        val year = myClaender.get(Calendar.YEAR)
        val month = myClaender.get(Calendar.MONTH)
        val day = myClaender.get(Calendar.DAY_OF_MONTH)
       val dpd =  DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                setInMinutesLabel(selectedYear,selectedMonth,selectedDayOfMonth)


//                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
//                val theDate = sdf.parse(selectedDate)
            },
            year,
            month,
            day)
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
    private fun setInMinutesLabel(selectedYear: Int, selectedMonth:Int, selectedDayOfMonth:Int){
        val selectedDate: String = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
        tvSelectedDate.text = selectedDate
        ResultAge.text = DateCalculator().calculateAgeInMinutes(selectedDate)
    }
}