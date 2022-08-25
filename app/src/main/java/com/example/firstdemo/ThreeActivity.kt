package com.example.firstdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firstdemo.databinding.ActivityThreeBinding

/**
 * Description: This is the activity class of ThreeActivity,
 *              And this is use for showing the action that
 *              send the data form one activity to another.
 * @author Abhishek Oza.
 * @since 16th March 2022.
 */

class ThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnSend.setOnClickListener(View.OnClickListener {

            if (binding.name.text.isEmpty()) {

                binding.name.error = "Please fill this"
            } else if (binding.age.text.isEmpty()) {
                binding.age.error = "Please fill this"
            } else if (binding.country.text.isEmpty()) {
                binding.country.error = "Please fill this"
            } else {


                val name = binding.name.text.toString()
                val age = binding.age.text.toString()
                val country = binding.country.text.toString()

                Intent(this, ReceiveActivity::class.java).also {
                    it.putExtra("EXTRA_NAME", name)
                    it.putExtra("EXTRA_AGE", age)
                    it.putExtra("EXTRA_COUNTRY", country)
                    startActivity(it)
                }
            }


        })


    }
}