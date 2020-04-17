package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

const val EXTRA_HISTORY = "com.example.acalculator.HISTORIC"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private val TAG = MainActivity::class.java.simpleName
    private val VISOR_KEY = "visor";

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG,"O método onCreate foi invocado");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationManager.goToCalculatorFragment(supportFragmentManager)
        setSupportActionBar(toolbar)
        setupDrawerMenu()
       if(!screenRotated(savedInstanceState)) {
           NavigationManager.goToCalculatorFragment(supportFragmentManager);
       }
    }

    private fun screenRotated(savedInstanceState: Bundle?): Boolean {
        return savedInstanceState != null;
    }

    private fun setupDrawerMenu() {
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        nav_drawer.setNavigationItemSelectedListener(this);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed();
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_calculator -> NavigationManager.goToCalculatorFragment(supportFragmentManager);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    override fun onDestroy() {
        Log.i(TAG,"O método onDestroy foi invocado");
        super.onDestroy();
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY);
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString())}
        super.onSaveInstanceState(outState);
    }

}
