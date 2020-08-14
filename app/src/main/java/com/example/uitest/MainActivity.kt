package com.example.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomnavi = findViewById<View>(R.id.bottomnavi) as BottomNavigationView
        bottomnavi.setOnNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(p0:MenuItem): Boolean {
        when(p0.itemId){
            R.id.aitem ->{
                val fragmenta = ScreenSlidePageFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentlocation,fragmenta).commit()
            }
            R.id.bitem ->{
                val fragmentb = testfragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentlocation,fragmentb).commit()
            }
            R.id.citem ->{
                val fragmentc = ScreenSlidePageFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentlocation,fragmentc).commit()
            }
            R.id.ditem ->{
                val fragmentd = testfragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentlocation,fragmentd).commit()
            }
            R.id.eitem ->{
                val fragmente = ScreenSlidePageFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentlocation,fragmente).commit()
            }
        }
        return true
    }
}