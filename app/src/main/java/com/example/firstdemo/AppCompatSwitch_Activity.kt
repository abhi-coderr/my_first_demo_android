package com.example.firstdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.core.view.ContentInfoCompat
import androidx.core.view.isVisible
import com.example.firstdemo.databinding.ActivityAppCompatSwitchBinding
import kotlin.properties.Delegates

/**
 * Description: This activity is use for AppcompatSwitch UI component in this UI Demo Project.
 *
 * @author Oza Abhishek.
 * @since 3rd March 2022.
 */

class AppCompatSwitch_Activity : AppCompatActivity() {

    private lateinit var binding : ActivityAppCompatSwitchBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppCompatSwitchBinding.inflate(layoutInflater)
        setContentView(binding.root)

// This listener is used for execute the action when Switch is clicked by user.
        binding.onOf.setOnCheckedChangeListener { _, b ->
// See here, in parameter b is there, basically b is boolean if b is false then first code is execute.
            if(b==false){
                binding.changeLayout.background = ActivityCompat.getDrawable(this, R.drawable.button_color)
                binding.textForMagic.isVisible=false
                binding.askText.isVisible=true
                binding.magicText.isVisible=false

            }
//            And your b is not false means b is true then your else part will be execute.
            else{
                binding.changeLayout.background = ActivityCompat.getDrawable(this, R.drawable.lastone)
                binding.textForMagic.isVisible=false
                binding.magicText.isVisible=true
                binding.askText.isVisible=false
            }

        }
//          This button(btnStatus) is used for showing the status of the user, that in which area is there.
        binding.btnStatus.setOnClickListener(View.OnClickListener {
            if (binding.onOf.isChecked){
                Toast.makeText(this,"In Universe ✨💥🎊",Toast.LENGTH_SHORT).show()
            }
            else{

                Toast.makeText(this,"Non Universe Area",Toast.LENGTH_SHORT).show()
            }

        })




    }

}