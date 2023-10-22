package com.example.form

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.form.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var isChecked : Boolean = false
        val genderGroup : RadioGroup = findViewById(R.id.gender)
        genderGroup.setOnCheckedChangeListener{ group, checkedID ->
            val radioButton : RadioButton = findViewById<RadioButton>(checkedID)
            val value = radioButton.text.toString()
            isChecked = when (checkedID) {
                R.id.male -> true
                R.id.female -> true
                else -> false
            }
        }
        val registerButton = findViewById<Button>(R.id.register)
        registerButton.setOnClickListener {
            val firstName : EditText = findViewById(R.id.firstName)
            val lastName : EditText = findViewById(R.id.lastName)
            val birthDay : EditText = findViewById(R.id.dob)
            val address : EditText = findViewById(R.id.address)
            val email : EditText = findViewById(R.id.email)
            val isValid = formValidation(firstName.text.toString(), lastName.text.toString(), birthDay.text.toString(), address.text.toString(), email.text.toString(), isChecked)
            if (isValid){
                Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "All field is required", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun formValidation(firstName: String, lastName:String , birthDay: String, address:String, email:String, isChecked:Boolean): Boolean {
        if (firstName=="") {
            return false;
        }

        if (lastName=="") {
            return false;
        }

        if (birthDay=="") {
            return false;
        }

        if (address=="") {
            return false;
        }

        if (email=="") {
            return false;
        }

        if (!isChecked) {
            return false;
        }
        return true
    }

}