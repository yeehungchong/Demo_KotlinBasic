package com.yeehungchong.demokotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetAge.setOnClickListener {
            val userDOB = etDOB.text.toString()
            if (userDOB.isNotEmpty()) {
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - userDOB.toInt()
                var criterion = ""

//                if (age < 18) {
//                    criterion = "Underage"
//                } else if (age in 18..65) {
//                    criterion = "Young people"
//                } else if (age in 66..79) {
//                    criterion = "Middle-aged"
//                } else if (age in 80..99) {
//                    criterion = "Elderly"
//                } else {
//                    criterion = "Long-lived elderly"
//                }

                when (age) {
                    in 0..17 -> criterion = "Underage"
                    in 18..65 -> criterion = "Young people"
                    in 66..79 -> criterion = "Middle-aged"
                    in 80..99 -> criterion = "Elderly"
                    else -> {
                        criterion = "Long-lived elderly"
                    }
                }

                tvShowAge.text = "Your age is $age"
                tvShowCriterion.text = criterion
            } else {
                Toast.makeText(this, "Please enter your birth year", Toast.LENGTH_SHORT).show()
            }


        }
    }
}