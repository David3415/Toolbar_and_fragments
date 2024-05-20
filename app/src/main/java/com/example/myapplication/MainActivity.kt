package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            open.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
                navView.setNavigationItemSelectedListener {
                    when (it.itemId) {
                        R.id.menu11 -> Toast.makeText(this@MainActivity, "Item11", Toast.LENGTH_SHORT).show()
                    }
                    //drawer.closeDrawer(GravityCompat.START)
                    true
                }
            }
        }
        /*supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Admin"*/
        //binding.bNav.selectedItemId = R.id.ic_del
        /* binding.bNav.setOnNavigationItemSelectedListener {
             when (it.itemId) {
                 // android.R.id.home -> finish()
                 R.id.ic_save -> {
                     Toast.makeText(this, "Del", Toast.LENGTH_SHORT).show()
                 }
                 R.id.ic_sync -> {
                     Toast.makeText(this, "Sync", Toast.LENGTH_SHORT).show()
                 }
             }
             true
         }*/
    }

    /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.main_menu, menu)
         menuInflater.inflate(R.menu.bottom_menu, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId) {
             // android.R.id.home -> finish()

         }
         return true
     }*/

}