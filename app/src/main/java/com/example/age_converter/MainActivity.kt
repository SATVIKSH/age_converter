package com.example.age_converter

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

import java.util.Calendar
import java.util.Calendar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val selectDateButton = findViewById<Button>(R.id.select_date_button)
        var date=""
        var currentDate:String=""
        selectDateButton.setOnClickListener { view ->
            val calendar=Calendar.getInstance()
            val year=calendar.get(YEAR)
            val month=calendar.get(MONTH)
            val day=calendar.get(DAY_OF_MONTH)
            currentDate="$day/${month+1}/$year"
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                    view,selectedYear,selectedMonth,selectedDay->
                val selectedDate="$selectedDay/${selectedMonth+1}/$selectedYear"
                date=selectedDate
             selectDateButton.text=selectedDate
            },year,month, day).show()
        }
        val toDays=findViewById<Button>(R.id.to_days_button)
        val toMinutes=findViewById<Button>(R.id.to_minutes_button)
        val toMonths=findViewById<Button>(R.id.to_months_button)
        toDays.setOnClickListener {
            if(date=="")
            {
                Toast.makeText(this,"Please select a date first !",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val convertTo="days"
            val intent=Intent(this,ConvertActivity::class.java)

            intent.putExtra("conversion",convertTo)
            intent.putExtra("date",date)
            startActivity(intent)
        }
        toMinutes.setOnClickListener {
            if(date=="")
            {
                Toast.makeText(this,"Please select a date first !",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val convertTo="minutes"
            val intent=Intent(this,ConvertActivity::class.java)

            intent.putExtra("conversion",convertTo)
            intent.putExtra("date",date)
            startActivity(intent)
        }
        toMonths.setOnClickListener {
            if(date=="")
            {
                Toast.makeText(this,"Please select a date first !",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val convertTo="months"
            val intent=Intent(this,ConvertActivity::class.java)

            intent.putExtra("conversion",convertTo)
            intent.putExtra("date",date)
            startActivity(intent)
        }
    }


}