package com.metex.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences: Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.metex.storingdata", Context.MODE_PRIVATE)

        ageFromPreferences= sharedPreferences.getInt("age",-1)

        if(ageFromPreferences ==-1){
            ageText.text= "Your Age: "
        }else{
            ageText.text= "Your Age: $ageFromPreferences"
        }
    }

    fun onSave(view: View){

        val myAge= textView.text.toString().toIntOrNull()

        if(myAge != null){

            ageText.text= "Your Age: " + myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }

    }

    fun onDelete(view: View){
        ageFromPreferences = sharedPreferences.getInt("age", -1)

        if(ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()
            ageText.text= "Your Age: "
        }
    }
}