package com.example.firstdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstdemo.databinding.ActivityReceiveBinding

/**
 * Description: This is the activity class of ReceiveActivity,
 *              And this is use for receive the data of ThreeActivity.
 *
 * @author Abhishek Oza.
 * @since 16th March 2022.
 */

class ReceiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReceiveBinding
    private lateinit var nameSecond: String
    private lateinit var ageSecond: String
    private lateinit var countrySecond: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getStringExtra("EXTRA_AGE")
        val country = intent.getStringExtra("EXTRA_COUNTRY")
        nameSecond = name.toString()
        ageSecond = age.toString()
        countrySecond = country.toString()

        val personString = "$name is $age your old and $name's country is $country"



        binding.receiveTextView.text = personString

        binding.pickImg.setOnClickListener {

            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
                startActivity(it)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 0) {
            val uri = data?.data.toString()


            Intent(this, ProfileActivity::class.java).also {
                it.putExtra("EXTRA_URI", uri)
                it.putExtra("EXTRAName", nameSecond)
                it.putExtra("EXTRAAge", ageSecond)
                it.putExtra("EXTRACountry", countrySecond)

                startActivity(it)
            }

        }
    }

}