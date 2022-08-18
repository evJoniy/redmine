package com.evj.redmine

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainViewModel by viewModels()
        model.issues.observe(this) { issues ->
            Toast.makeText(this, issues, Toast.LENGTH_SHORT).show()
        }

        val editLogin = findViewById<EditText>(R.id.login)
        val editPass = findViewById<EditText>(R.id.password)

        val loginBtn = findViewById<View>(R.id.login_btn) as Button
        loginBtn.setOnClickListener {
            val login = editLogin.text.toString().trim { it <= ' ' }
            val pass = editPass.text.toString().trim { it <= ' ' }

            if (login.isEmpty()) {
                editLogin.error = "Login is required"
                editLogin.requestFocus()
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                editPass.error = "Password is required"
                editPass.requestFocus()
                return@setOnClickListener
            }

            model.auth()

        }
    }
}