package com.example.firstdemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstdemo.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val img = intent.getStringExtra("EXTRA_URI")
        val name = intent.getStringExtra("EXTRAName")
        val age = intent.getStringExtra("EXTRAAge")
        val country = intent.getStringExtra("EXTRACountry")

        binding.idName.text = "$name"
        binding.designation.text = "$age"
        binding.srkMail.text = "$country"



        binding.srkImage.setImageURI(Uri.parse(img))



    }
}