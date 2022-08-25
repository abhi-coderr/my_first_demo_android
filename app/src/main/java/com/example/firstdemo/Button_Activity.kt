package com.example.firstdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.firstdemo.databinding.ActivityButtonBinding

/**
 *
 * Description: This is the activity class of Button_Activity,
 *              And this is used for execution the task of button clickEvent.
 *
 * @author: Abhishek Oza.
 * @since: 2nd March 2022.
 */

class Button_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityButtonBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      This is the listener in which magic will be create. clicking on button, color will be change of btn.
        binding.btn.setOnClickListener(View.OnClickListener {

            binding.btn.background = ActivityCompat.getDrawable(this, R.drawable.button_color)

            Toast.makeText(this,"Here is Magic....✨✨",Toast.LENGTH_LONG).show()

        })
    }

}


