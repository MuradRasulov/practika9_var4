package com.example.practika9_var4

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var editText_Full_name: EditText
    private lateinit var editText_Age: EditText
    private lateinit var editText_Phone_number: EditText
    private lateinit var editText_Email: EditText
    private lateinit var editText_Gender: Spinner

    private var edText_Full_name: Boolean = false
    private var edText_Age: Boolean = false
    private var edText_Phone_number: Boolean = false
    private var edText_Email: Boolean = false

    private lateinit var buttonResult: Button
    private lateinit var intentResult: Intent

    val gender = arrayOf("М", "Ж")

    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_Full_name = findViewById(R.id.editTextTextPersonName)
        editText_Age = findViewById(R.id.editTextTextPersonName2)
        editText_Phone_number = findViewById(R.id.editTextPhone)
        editText_Email = findViewById(R.id.editTextTextEmailAddress)
        editText_Gender = findViewById(R.id.spinner)

        buttonResult = findViewById(R.id.button)
        buttonResult.isEnabled = false
        buttonResult.setBackgroundColor(getColor(R.color.gray))

        fun checkEditText() {
            buttonResult.isEnabled = edText_Full_name && edText_Age && edText_Phone_number && edText_Email
            if (buttonResult.isEnabled) { buttonResult.setBackgroundColor(getColor(R.color.purple_500))
            } else { buttonResult.setBackgroundColor(getColor(R.color.gray)) }
        }

        editText_Full_name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                edText_Full_name = p0.hashCode() == editText_Full_name.text.hashCode() && p0!!.isNotEmpty()
                checkEditText()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        editText_Age.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                edText_Age = p0.hashCode()  == editText_Age.text.hashCode() && p0!!.isNotEmpty()
                checkEditText()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        editText_Phone_number.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                edText_Phone_number = p0.hashCode() == editText_Phone_number.text.hashCode() && p0!!.isNotEmpty()
                checkEditText()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        editText_Email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                edText_Email = p0.hashCode() == editText_Email.text.hashCode() && p0!!.isNotEmpty()
                checkEditText()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

       // val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gender)
        editText_Gender.adapter = arrayAdapter
        editText_Gender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext, "Вы выбрали пол - " + gender[p2], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext, "Выберите свой пол!" + gender, Toast.LENGTH_SHORT).show()
            }
        }

        /*buttonResult.setOnClickListener {
            intentResult = Intent(this, SecondActivity::class.java)
            intentResult.putExtra("ФИО", editText_Full_name.text.toString())
            intentResult.putExtra("Возраст", editText_Age.text.toString())
            intentResult.putExtra("Номер телефона", editText_Phone_number.text.toString())
            intentResult.putExtra("Почта", editText_Email.text.toString())
            startActivity(intentResult)
        }*/

    }
    fun result(view: View){
        val name = editText_Full_name.text.toString()
        val age = editText_Age.text.toString()
        val gender = editText_Gender.selectedItem.toString()
        val phone_number = editText_Phone_number.text.toString()
        val email = editText_Email.text.toString()
        val message = "ФИО :${name} \nВозраст :${age} \nПол :${gender} \nНомер телефона :${phone_number} \nПочта :${email}\n"

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("EXTRA_MESSAGE", message)
        startActivity(intent)

    }
}

//private fun EditText.addTextChangedListener(textWatcher: TextWatcher, function: () -> Unit) {
