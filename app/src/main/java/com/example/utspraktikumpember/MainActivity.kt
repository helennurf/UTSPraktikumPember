package com.example.utspraktikumpember

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.frame_container, ListFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_list -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, ListFragment()).commit()
                true
            }
            R.id.menu_grid -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, GridFragment()).commit()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}