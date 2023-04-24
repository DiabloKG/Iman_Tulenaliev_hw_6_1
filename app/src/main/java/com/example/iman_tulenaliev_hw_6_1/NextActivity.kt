package com.example.iman_tulenaliev_hw_6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iman_tulenaliev_hw_6_1.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setText()
        clickListener()
    }

    private fun setText() {
        binding.etSecond.setText(intent.getStringExtra("inputEditText"))
    }

    private fun clickListener() {
        binding.btnSecond.setOnClickListener {
            val intent = Intent()
            intent.putExtra("outputEditText", binding.etSecond.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}