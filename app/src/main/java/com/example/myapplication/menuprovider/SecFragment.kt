package com.example.myapplication.menuprovider

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.example.myapplication.R


class secFragment : Fragment(), MenuProvider {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
               (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sec, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(this, viewLifecycleOwner)
    }

    companion object {


        @JvmStatic
        fun newInstance() = secFragment()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.sec_activity_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.return_back -> {
                Toast.makeText(requireContext(), "Sync", Toast.LENGTH_LONG).show()
                (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentsHost, MainFragment.newInstance())
                    .commit()

            }
        }
        return true
    }
}