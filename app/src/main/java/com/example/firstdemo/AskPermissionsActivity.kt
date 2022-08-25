package com.example.firstdemo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.firstdemo.databinding.ActivityAskPermissionsBinding

/**
 * Description: This is the activity class of AskPermissionsActivity,
 *              And this is used for showing that, how permission can work in android kotlin.
 * @author Abhishek R Oza.
 * @since 21st March 2022.
 */

class AskPermissionsActivity : AppCompatActivity() {

    // this binding variable is used to binding the ides of xml root file.
    private lateinit var binding: ActivityAskPermissionsBinding
    // below all variables are used for request purpose which can used for identify that which permission will occur.
    val FINE_LOCATION_RQ = 101
    val CAMERA_RQ = 102
    val CALL_RQ = 103
    val CALL = true
    val READ_EXTERNAL = 104
    val WRITE_EXTERNAL = 105


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAskPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // calling the callBtn function.
       callBtn()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    // the function that ask permission to user when user tap the TextView,
    // and button click event for call the dial number.
    private fun callBtn() {
        binding.permissionTV.setOnClickListener {
            checkForPermission(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                "location",
                FINE_LOCATION_RQ
            )
            checkForPermission(android.Manifest.permission.CAMERA, "camera", CAMERA_RQ)
            checkForPermission(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                "read storage",
                READ_EXTERNAL
            )
            checkForPermission(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                "write storage",
                WRITE_EXTERNAL
            )
            checkForPermission(android.Manifest.permission.CALL_PHONE, "CALL", CALL_RQ)
        }
        binding.callBtn.setOnClickListener {

             if(binding.phoneET.text.isNotBlank()){
                val number = binding.phoneET.text.toString()
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Dial number first",Toast.LENGTH_SHORT).show()
            }

        }
    }


    // This function is used to manage the permission that selected by users.
    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkForPermission(permission: String, name: String, requestCode: Int) {

            when {
                ContextCompat.checkSelfPermission(
                    applicationContext,
                    permission
                ) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "$name permission granted", Toast.LENGTH_SHORT).show()


                }
                shouldShowRequestPermissionRationale(permission) -> {
                    ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
                }
                else ->showDialog(permission, name, requestCode)
            }

    }
    // function that used when user do the action again the permissions.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fun innerCheck(name: String) {
            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "$name permission refused", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$name permission granted", Toast.LENGTH_SHORT).show()
            }

            when (requestCode) {
                FINE_LOCATION_RQ -> innerCheck("location")
                CAMERA_RQ -> innerCheck("camera")
                CALL_RQ -> innerCheck("Call")
                READ_EXTERNAL -> innerCheck("read storage")
                WRITE_EXTERNAL -> innerCheck("write storage")
            }
        }
    }
    // this function is used to create and show the AlertDialog Box when user deny the permission forcefully.
    private fun showDialog(permission: String, name: String, requestCode: Int) {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Please go to setting and get the $name permission")
            setTitle("Permission required")
            setPositiveButton("OK") { _, which ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
                finish()

            }
        }
        val dialog = builder.create()
        dialog.show()



    }

}