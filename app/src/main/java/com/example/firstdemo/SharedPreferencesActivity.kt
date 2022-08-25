package com.example.firstdemo

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings.Global.putString
import com.example.firstdemo.databinding.ActivitySharedPreferencesBinding

/**
 * Description: This is the activity class of SharedPreferencesActivity,
 *              And this is used for showing the how shared preferences work in android kotlin.
 * @author Abhishek R Oza.
 * @since 22nd March 2022.
 */
class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesBinding
    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        val editor = sharedPref.edit()

        binding.save.setOnClickListener {
            val fName = binding.firstName.text.toString()
            val lName = binding.lastName.text.toString()
            val pNumber = binding.phoneNumber.text.toString().toInt()


            editor.apply {
                putString("firstN", fName)
                putString("lastN", lName)
                putInt("phoneN", pNumber)
                apply()
            }
        }

        val fN = sharedPref.getString("firstN", null)
        val lN = sharedPref.getString("lastN", null)
        val pN = sharedPref.getInt("phoneN", 0)


        binding.firstName.setText(fN)
        binding.lastName.setText(lN)
        binding.phoneNumber.setText(pN.toString())

        binding.getImage.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val shared = getSharedPreferences("yourPref", Context.MODE_PRIVATE)

        val edit = shared.edit()

        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data

        }
        edit.apply {
            putString("uriP", imageUri.toString())
            apply()
        }
        val uriImage = shared.getString("uriP", null)
        binding.getImage.setImageURI(Uri.parse(uriImage.toString()))
        binding.getImage.setImageURI(Uri.parse(imageUri.toString()))
    }


}