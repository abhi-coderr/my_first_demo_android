package com.example.firstdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstdemo.databinding.ActivitySpinnerBinding


/**
 * Description: This the activity class of SpinnerActivity,
 *              This is used to user for showing the demo of spinner project.
 * @author: Abhishek Oza.
 * @since: 10th March 2022.
 */

class SpinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerBinding
    private var list = arrayListOf<String>("Select Item")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.spinnerView.adapter =
            ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                list
            )






        binding.btnADD.setOnClickListener(View.OnClickListener {
            val textInEditText = binding.editView.text.toString()
            if (textInEditText.isNotBlank()) {
                Log.d("SpinnerActivity", binding.spinnerView.selectedItemPosition.toString())
                list.add(textInEditText)
                binding.editView.setText("")
            }
        })

        binding.spinnerView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                selectedPosition: Int,
                p3: Long
            ) {
                if (selectedPosition != 0) {
                    Toast.makeText(
                        this@SpinnerActivity,
                        "selected item :${list[selectedPosition]}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) = Unit


        }


    }


}