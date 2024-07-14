package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var conf: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.ab.toolbar)
        var K = findViewById<View>(R.id.actionbar1)
        //supportActionBar?.setTitle(R.string.back_to_main_frag)

                //binding.ab.toolbar?.
            //getSupportActionBar()?.setTitle("My title")
        navController = findNavController(R.id.fragmentContainerView)
        conf = AppBarConfiguration(
            setOf(
                R.id.item1,
                R.id.item2
            ), binding.drawerLayout
        )

        setupActionBarWithNavController(navController, conf)
        binding.navView.setupWithNavController(navController)
    }

    var aa = "dfs"
    override fun onSupportNavigateUp(): Boolean {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.item1 -> {
                    val resource = getString(R.string.frag_1)
                    Log.d("MyLog", "res: $resource")
                    title = resource
                }

                R.id.item2 -> {
                    val resource = getString(R.string.frag_2)
                    Log.d("MyLog", "res: $resource")
                    title = resource
                }

                else -> "onSupportNavigateUp ERROR"
            }
        }

        return navController.navigateUp(conf) || super.onSupportNavigateUp()
    }
}