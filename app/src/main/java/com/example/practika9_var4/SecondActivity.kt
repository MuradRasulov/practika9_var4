package com.example.practika9_var4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = message
        //textV.text = "ФИО :${(intent.getStringExtra("ФИО"))!!.toString()}\nВозраст :${intent.getStringExtra("Возраст")!!.toString()}\nПол :${intent.getStringExtra("Пол")!!.toString()}\nНомер телефона :${intent.getStringExtra("Номер телефона")!!.toString()}\nПочта :${intent.getStringExtra("Почта")!!.toString()}\n "

    }
    fun back(view: View){
        val intent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(intent)
    }
}