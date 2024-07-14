package com.example.myapplication.menuprovider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider
import com.example.myapplication.R

class MainFragment : Fragment(), MenuProvider {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(this, viewLifecycleOwner)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.main_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.open_frag2 -> {
                Toast.makeText(requireContext(), "Sync", Toast.LENGTH_LONG).show()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentsHost, secFragment.newInstance())
                    .commit()
            }

            R.id.about -> {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentsHost, ThirdFragment.newInstance())
                    .commit()
            }

        }
        return true
    }
}