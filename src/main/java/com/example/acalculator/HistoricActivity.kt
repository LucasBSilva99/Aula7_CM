package com.example.acalculator

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.acalculator.MainActivity
import com.example.acalculator.R
import kotlinx.android.synthetic.main.activity_history.*
import java.text.SimpleDateFormat
import java.util.*

const val EXTRA_NAME = "com.github.mstavares.cm.calculadora.NAME"

class HistoricActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

}