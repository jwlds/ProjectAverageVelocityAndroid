package com.example.averagevelocity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.averagevelocity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btnCall.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        hideSoftKeyboard()
        try {
            val am= AverageVelocity(
                binding.TI.text.toString().toDouble(),
                binding.TF.text.toString().toDouble(),
                binding.VI.text.toString().toDouble(),
                binding.VF.text.toString().toDouble(),
            ).calcular()

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("am",am)
            this.startActivity(intent)
            finish()


        }catch (arg : IllegalArgumentException){
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun hideSoftKeyboard(){
        val softKeyManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        softKeyManager.hideSoftInputFromWindow(binding.btnCall.windowToken, 0)
    }
}