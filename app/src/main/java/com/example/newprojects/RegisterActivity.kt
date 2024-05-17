package com.example.newprojects

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newprojects.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    lateinit var  registerBinding: ActivityRegisterBinding
    lateinit var  sharedPreferences: SharedPreferences
    lateinit var  spinner: Spinner
    var gender = arrayOf("Male", "Female")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)
        spinner =findViewById(R.id.spinner)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, gender)
        spinner.setSelection(0)



        val saveButton = findViewById<Button>(R.id.registerbutton)
        saveButton.setOnClickListener {
            // Save the user data here
            saveUserData()
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun saveUserData() {
        // Assuming you save user data to SharedPreferences or another storage
        // For example:
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("gender", gender[spinner.selectedItemPosition])
        // Save other user data similarly
        editor.apply()
       Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_LONG).show()

        val intent = Intent(this, loginActivity::class.java)
        startActivity(intent)
        finish()
    }
}