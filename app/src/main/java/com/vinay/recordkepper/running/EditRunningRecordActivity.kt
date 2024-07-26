package com.vinay.recordkepper.running

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.vinay.recordkepper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditRunningRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val distance = intent.getStringExtra("Distance")
        title = "$distance Record"

        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        applicationPreferences.edit {
            putString("Some application data", "Application Preference value")
        }

        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
        activityPreferences.edit {
            putInt("Some activity data",15)
        }

        val fileNamePreferences = getSharedPreferences("some shared preferences name",Context.MODE_PRIVATE)

        fileNamePreferences.edit {
            putBoolean("some preference file name data", false)
        }

    }
}