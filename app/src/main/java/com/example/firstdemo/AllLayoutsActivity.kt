package com.example.firstdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.firstdemo.databinding.ActivityAllLayoutsBinding
import com.example.firstdemo.databinding.ActivityMainBinding

/**
 * Description: This activity is used for your all layout demo.
 *
 * @author: Oza Abhishek.
 * @since: 3rd March 2022.
 */
class AllLayoutsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllLayoutsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllLayoutsBinding.inflate(layoutInflater)
        setContentView(binding.root)

// This listener is used for executing the btn1's actions

        binding.btn1.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)

        })

// This listener is used for executing the btn2's actions

        binding.btn2.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, XdDesignActivity::class.java)
            startActivity(intent)

        })
// this is the button click listener of btn3, That show the shared preferences demo.
        binding.btn3.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, SharedPreferencesActivity::class.java)
            startActivity(intent)

        })


    }
}