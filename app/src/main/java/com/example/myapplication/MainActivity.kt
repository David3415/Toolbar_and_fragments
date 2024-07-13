package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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