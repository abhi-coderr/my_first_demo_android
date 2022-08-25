package com.example.firstdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstdemo.adapters.MyAdapter
import com.example.firstdemo.dataClasses.PojoClass
import com.example.firstdemo.databinding.ActivityNestedBinding

/**
 *
 * Description: This is the class of NestedActivity and this is used for scrollView.
 *
 * @author: Abhishek Oza.
 * @since:7th March 2022.
 */

class NestedActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityNestedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNestedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var sList = mutableListOf(
            PojoClass("Abhishek"),
            PojoClass("Ankit Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai"),
            PojoClass("Krunal Bhai")
        )
        var pList = mutableListOf(
            PojoClass("Abhilasha ben"),
            PojoClass("Ankita Ben"),
            PojoClass("Krunal Bhai"),
            PojoClass("pravina ben"),
            PojoClass("virat Bhai"),
            PojoClass("bharat Bhai"),
            PojoClass("samir Bhai"),
            PojoClass("kamal Bhai"),
            PojoClass("vivek Bhai"),
            PojoClass("smit Bhai"),
            PojoClass("kamla ben"),
            PojoClass("ravi Bhai"),
            PojoClass("vasant Bhai"),
            PojoClass("ronak Bhai")
        )

        val adapter = MyAdapter(sList)
        binding.rvFirst.adapter = adapter
        binding.rvFirst.layoutManager = LinearLayoutManager(this)

        val adapter2 = MyAdapter(pList)
        binding.rvSecond.adapter = adapter2
        binding.rvSecond.layoutManager = LinearLayoutManager(this)





    }
}