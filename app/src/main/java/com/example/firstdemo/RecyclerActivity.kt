package com.example.firstdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firstdemo.databinding.ActivityRecyclerBinding

/**
 * Description: This activity is the inner activity of RecyclerActivity.
 *
 * @author: Abhishek Oza.
 * @since: 7th March 2022.
 */
class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.nested.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Nested",Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,NestedActivity::class.java)
            startActivity(intent)
        })

        binding.multipleClick.setOnClickListener(View.OnClickListener {

            Toast.makeText(this,"Multiple Selection",Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this,MultipleSelectionActivity::class.java)
            startActivity(intent)
        })


    }
}