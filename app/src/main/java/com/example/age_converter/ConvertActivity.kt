package com.example.age_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.Period
import java.util.*

class ConvertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)
        val selectedDate=intent.getStringExtra("date")


        val conversion=intent.getStringExtra("conversion")
        val secondTitle=findViewById<TextView>(R.id.second_title)
        val thirdTitle=findViewById<TextView>(R.id.third_title)
        val toYear=findViewById<TextView>(R.id.in_years)
        val convertedDate=findViewById<TextView>(R.id.converted_date)
        val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val calendarDate=Calendar.getInstance()
        val calendarNow=Calendar.getInstance()
        val theDate=sdf.parse(selectedDate)
        calendarDate.time=theDate
        val theCurrentDate=Date()
        val differenceInMillis=(theCurrentDate.time)-(theDate.time)
        val differenceInYears= calendarNow.get(Calendar.YEAR)-calendarDate.get(Calendar.YEAR)
        toYear.text=differenceInYears.toString()
        if(conversion=="days")
        {
           thirdTitle.text="in $conversion"
            val differenceInDays=differenceInMillis/(24*60*60*1000)
            convertedDate.text=differenceInDays.toString()

        }
        if(conversion=="minutes")
        {
            thirdTitle.text="in $conversion"
            val differenceInMinutes=differenceInMillis/(60*1000)
            convertedDate.text=differenceInMinutes.toString()

        }
        if(conversion=="months")
        {
            thirdTitle.text="in $conversion"
            val differenceInMonths=(differenceInYears*12)+calendarNow.get(Calendar.MONTH)-calendarDate.get(Calendar.MONTH)
            convertedDate.text=differenceInMonths.toString()

        }
    }
}