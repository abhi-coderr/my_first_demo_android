package com.example.firstdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import kotlin.properties.Delegates

/**
 * Description : This activity is used for RadioButton UI component in this UI demo project.
 *
 * @author : Oza Abhishek.
 * @since : 3rd March 2022.
 */
class RadioButtonActivity : AppCompatActivity() {

    /**
     * Description : This all variables are use for radiobutton onclick event.
     */

    lateinit var redioGroup: RadioGroup
    lateinit var male: RadioButton
    lateinit var female: RadioButton
    lateinit var other: RadioButton

     var flag : Boolean=false

    //This is for change in layout background
    lateinit var redioRelative: RelativeLayout

//    This variable is used for execute the action for button
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        redioGroup = findViewById(R.id.redioGroup)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        other = findViewById(R.id.other)
//        layout id assignment to variable
        redioRelative = findViewById(R.id.radioRelative)
//        button id assignment to variable of btn
        btn = findViewById(R.id.submitBtn)


        redioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.male -> {
                    redioRelative.setBackgroundColor(Color.parseColor("#FF33B5E5"))


                }
                R.id.female -> {
                    redioRelative.setBackgroundColor(Color.parseColor("#FFBB86FC"))

                }
                R.id.other -> {
                    redioRelative.setBackgroundColor(Color.parseColor("#FF007A6F"))

                }
            }
        }

        btn.setOnClickListener(View.OnClickListener {
            when {
                male.isChecked -> {
                    Toast.makeText(this,"Male",Toast.LENGTH_SHORT).show()
                }
                female.isChecked -> {
                    Toast.makeText(this,"female",Toast.LENGTH_SHORT).show()
                }
                other.isChecked -> {
                    Toast.makeText(this,"other",Toast.LENGTH_SHORT).show()
                }
            }
        })




    }
}