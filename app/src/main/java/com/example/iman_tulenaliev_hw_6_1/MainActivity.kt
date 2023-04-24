package com.example.iman_tulenaliev_hw_6_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.example.iman_tulenaliev_hw_6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val startForResult =
        registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val outputText = result.data?.getStringExtra("outputEditText")
                binding.etFirst.setText(outputText)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
    }

    private fun clickListener() {
        binding.btnFirst.setOnClickListener {
            if (binding.etFirst.text.isEmpty()) {
                Toast.makeText(this, "Enter something", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this@MainActivity, NextActivity::class.java)
                intent.putExtra("inputEditText", binding.etFirst.text.toString())
                setResult(Activity.RESULT_OK, intent)
                startForResult.launch(intent)
            }
        }
    }
}
