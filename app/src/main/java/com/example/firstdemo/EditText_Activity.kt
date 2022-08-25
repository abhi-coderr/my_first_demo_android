package com.example.firstdemo

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firstdemo.databinding.ActivityEditTextBinding

/**
 * Description : This is the activity of EditText.
 *
 * @author : Abhishek Oza.
 * @since : 2st March 2022.
 */

class EditText_Activity : AppCompatActivity() {

    private lateinit var binding : ActivityEditTextBinding

//    lateinit var edit1:EditText
//    lateinit var edit2:EditText
//    lateinit var btnLogin:Button
    val email_add:String =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLogin.setOnClickListener(View.OnClickListener {


            var email:String = binding.edit1.text.toString()
            val password:String = binding.edit2.text.toString()

                if(email.trim().isEmpty()){
                    Toast.makeText(this,"Kindly fill email",Toast.LENGTH_SHORT).show()
                }
            else if (!email.matches(email_add.toRegex())){
                    Toast.makeText(this,"Invalid email ",Toast.LENGTH_SHORT).show()
                }
                else if (password.trim() .isEmpty()){
                    Toast.makeText(this,"Kindly fill password",Toast.LENGTH_SHORT).show()
                }
                else if (password.trim().length<5){
                    Toast.makeText(this,"Your password is week",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Email is "+email+" & Password is "+password,Toast.LENGTH_SHORT).show()
                }



        })

    }
}