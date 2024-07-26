package com.vinay.recordkepper.running

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.vinay.recordkepper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditRunningRecordBinding
    private  val runningPreferences by lazy { getSharedPreferences("running", Context.MODE_PRIVATE) }
    private  val distance by lazy { intent.getStringExtra("Distance") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "$distance Record"

        setUpUI()
        displayRecord()
    }
    private fun setUpUI() {
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            deleteRecord()
            finish()
        }
    }

    private fun deleteRecord() {

        runningPreferences.edit {
            remove("$distance record")
            remove("$distance date")
        }

    }
    private fun displayRecord() {
        binding.editTextRecord.setText(runningPreferences.getString("$distance record",null))
        binding.editTextDate.setText(runningPreferences.getString("$distance date",null))
    }
    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()
        runningPreferences.edit {
            putString("$distance record",record)
            putString("$distance date", date)
        }
    }
}