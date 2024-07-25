package com.vinay.recordkepper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView
import com.vinay.recordkepper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.reset_running ->{
                Toast.makeText(this,"Clicked the Reset Running menu item", Toast.LENGTH_LONG).show()
                true
            }
            R.id.reset_cycling ->{
                Toast.makeText(this,"Clicked the Reset Cycling menu item", Toast.LENGTH_LONG).show()
                true
            }
            R.id.reset_all ->{
                Toast.makeText(this,"Clicked the Reset All menu item", Toast.LENGTH_LONG).show()
                true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }
    }
    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }
    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }
    override fun onNavigationItemSelected(item: MenuItem) = when(item.itemId){
        R.id.nav_cycling -> onCyclingClicked()
        R.id.nav_running -> onRunningClicked()
        else -> false
    }
}