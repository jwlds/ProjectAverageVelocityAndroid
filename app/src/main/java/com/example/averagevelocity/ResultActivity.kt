package com.example.averagevelocity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.averagevelocity.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnBack.setOnClickListener(this)

        if(intent.hasExtra("am")){
            val am = intent.getDoubleExtra("am",0.0)
            binding.result.text = String.format("%.2f",am)

        } else finish()
    }




    override fun onClick(v: View?) {
        if(v!!.id == R.id.btnBack) backActivity()
    }

    private fun backActivity() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}