package com.jbenis.techtoolkit

import android.os.Bundle
import android.support.constraint.Placeholder
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        navigationView.itemIconTintList = null

    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val cancelMenuItem = menu.getItem(0)

        this.menu = menu
        val vectorDrawableCompat = VectorDrawableCompat.create(resources, R.drawable.vd_test_vd, null)
        val menuItem = menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.vd_test_vd))

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val fragmentManager = supportFragmentManager
        if (id == R.id.nav_main){
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, mainView())
                    .commit()
        }
        if (id == R.id.nav_nonsudolinux) {
            val linux = linuxFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, linux)
                    .commit()

        } else if (id == R.id.nav_sudoLinux) {
            val sudoLinux = sudoLinuxFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, sudoLinux)
                    .commit()

        } else if (id == R.id.nav_gallery) {
            val linuxPackages = linuxPackagesFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, linuxPackages)
                    .commit()

        } else if (id == R.id.nav_share) {
            val windowsAdmin = windowsAdminFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, windowsAdmin)
                    .commit()

        } else if (id == R.id.nav_send) {
            val windowsNoAdmin = windowsNoAdminFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, windowsNoAdmin)
                    .commit()

        } else if (id == R.id.nav_tools) {
            val windowsTools = windowsToolsFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, windowsTools)
                    .commit()

        } else if (id == R.id.nav_view) {
            val macOSSudo = macOSSudoFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, macOSSudo)
                    .commit()

        } else if (id == R.id.nav_nonsudomacos) {
            val macOSNoSudo = macOSFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, macOSNoSudo)
                    .commit()

        } else if (id == R.id.nav_toolsmacos) {
            val macOSTools = macOSToolsFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.mainView, macOSTools)
                    .commit()

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
