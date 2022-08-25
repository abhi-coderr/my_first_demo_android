package com.example.firstdemo

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.firstdemo.databinding.ActivityRatingBarBinding
import com.example.firstdemo.databinding.ActivityReceiveBinding

/**
 *
 * Description: This is the activity class of RatingBarActivity,
 *              And this is use for showing the demo how to work the ratingView in android kotlin.
 *
 * @author: Abhishek Oza.
 * @since: 11th March 2022.
 */

class RatingBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRatingBarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { _, _, _ ->


                when (binding.ratingBar.rating.toInt()) {
                    0 -> {
                        binding.status.text = "😶"
                        binding.thankImage.visibility = View.GONE
                    }
                    1 -> {
                        binding.status.text = "😏"
                        binding.thankImage.visibility = View.GONE
                    }
                    2 -> {
                        binding.status.text = "🙂"
                        binding.thankImage.visibility = View.GONE
                    }
                    3 -> {
                        binding.status.text = "😁"
                        binding.thankImage.visibility = View.GONE
                    }
                    4 -> {
                        binding.status.text = "😊"
                        binding.thankImage.visibility = View.GONE
                    }
                    5 -> {
                        binding.status.text = "🥰"
                        binding.thankImage.visibility = View.VISIBLE
                    }
                    else -> {
                        binding.status.text = "😶"
                        binding.thankImage.visibility = View.GONE
                    }


                }
//                Toast.makeText(this@RatingBarActivity, "Given rating is: $p1", Toast.LENGTH_SHORT)
//                    .show()
            }


        binding.btnSubmit.setOnClickListener(View.OnClickListener {

            binding.ratingText.text = binding.ratingBar.rating.toString()

        })

    }
}


