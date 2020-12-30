package com.example.androidkotlin.presentation.main

import com.example.androidkotlin.presentation.main.AccountCreation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.androidkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import android.content.Intent
import kotlinx.android.synthetic.main.account_creation.*
import kotlinx.android.synthetic.main.activity_main.password_edit

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    val intent = Intent(this, SymbolList::class.java)
                    startActivity(intent)
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Non-existing account")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()

                }
            }
        })

        login_button.setOnClickListener() {
            mainViewModel.onClickedLogin(
                login_edit.text.toString().trim(),
                password_edit.text.toString()
            )
        }

        create_account_button.setOnClickListener() {
            val intent = Intent(this, AccountCreation::class.java)
            startActivity(intent)
        }

        backButton1.setOnClickListener {
            val intent = Intent(this, Splash::class.java)
            startActivity(intent)
        }
    }


}