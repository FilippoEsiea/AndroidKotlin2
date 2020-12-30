package com.example.androidkotlin.presentation.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.androidkotlin.R
import com.example.androidkotlin.presentation.login.MainActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.account_creation.*
import org.koin.android.ext.android.inject

class AccountCreation : AppCompatActivity() {
    val createAccountViewModel: CreateAccountViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_creation)
        val button: Button = findViewById(R.id.signup_button)

        button.setOnClickListener {
            val emailCreate = email_edit.text.toString().trim()
            val passwordCreate = password_edit.text.toString()

            when {
                emailCreate.isNullOrEmpty() -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Email must be filled")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                passwordCreate.isNullOrEmpty()
                -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Password must be filled")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                else -> {
                    createAccountViewModel.onClickedCreate(emailCreate, passwordCreate)
                }
            }

            createAccountViewModel.createLiveData.observe(this, androidx.lifecycle.Observer {
                when (it) {
                    is CreateSuccess -> {
                        MaterialAlertDialogBuilder(this)
                            .setTitle("Account created")
                            .setPositiveButton("OK") { dialog, which ->
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            }
                            .show()
                    }
                    CreateError -> {
                        MaterialAlertDialogBuilder(this)
                            .setTitle("Error")
                            .setPositiveButton("OK") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                    }
                }
            })
        }

        backButton2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}