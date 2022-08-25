package com.example.firstdemo

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar

/**
 * Description : This activity is use for showing the demo of ProgressiveView in android KOTLIN.
 *
 * @author : Abhishek Oza.
 * @since : 4th March 2022.
 */
class ProgressActivity : AppCompatActivity() {
    // This below variables are lateinit type variables,
// And this variables are use for assignment of progressbar and button id's.
    lateinit var progress2: ProgressBar
    lateinit var btn1: Button
    lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        btn1 = findViewById(R.id.btnDecrease)
        btn2 = findViewById(R.id.btnIncrease)

        progress2 = findViewById(R.id.progress2)
//  This line is show that progress.2 variable's maximum size is 100.
        progress2.max = 100

//  This below listener is used for, if i will click on btn1 then decrease progressbar at 10 value.
        btn1.setOnClickListener(View.OnClickListener {

            progress2.progress = progress2.progress - 10
        })

//  This below listener is also used for increase the progressbar at 10 value.
        btn2.setOnClickListener(View.OnClickListener {

            progress2.progress = progress2.progress + 10

        })


    }
}