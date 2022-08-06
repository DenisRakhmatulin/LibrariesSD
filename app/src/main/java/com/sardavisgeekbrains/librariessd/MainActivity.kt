package com.sardavisgeekbrains.librariessd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sardavisgeekbrains.librariessd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnBoom.setOnClickListener {
                Toast.makeText(this@MainActivity, "Working!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}