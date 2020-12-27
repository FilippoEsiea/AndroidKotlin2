package com.example.androidkotlin.presentation.main
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.androidkotlin.R
import androidx.core.content.ContentProviderCompat.requireContext
import kotlinx.android.synthetic.main.account_creation.*
import java.util.*

class AccountCreation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_creation)

    }
}