package com.vannhat.androidbase.ui.screens

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.ActivityMainBinding
import com.vannhat.androidbase.ui.base.BaseActivity
import com.vannhat.androidbase.utils.ext.gone
import com.vannhat.androidbase.utils.ext.setupWithNavController
import com.vannhat.androidbase.utils.ext.visible

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int = R.layout.activity_main

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState!!)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_favorite
        )
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host,
            intent = intent
        )

        currentNavController = controller
        controller.observe(this, {
            listenDestinationChanged()
        })
    }

    private fun listenDestinationChanged() {
        currentNavController?.value?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentHome, R.id.fragmentFavorite -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun hideBottomNav() {
        if (binding.bottomNav.isVisible)
            binding.bottomNav.gone()
    }

    private fun showBottomNav() {
        if (!binding.bottomNav.isVisible)
            binding.bottomNav.visible()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}
