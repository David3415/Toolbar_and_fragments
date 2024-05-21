package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(BlankFragment.newInstance(), R.id.place_holder)
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)

      /*  supportFragmentManager.beginTransaction()
            .replace(binding.placeHolder.id, BlankFragment.newInstance()).commit()*/

       /* supportFragmentManager.beginTransaction()
            .replace(binding.placeHolder2.id, BlankFragment2.newInstance()).commit()*/

    }

    private fun openFrag(fragment: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction()
            .replace(idHolder, fragment).commit()
    }

}