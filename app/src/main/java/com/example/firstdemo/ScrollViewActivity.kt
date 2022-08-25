package com.example.firstdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstdemo.adapters.FirstAdapter
import com.example.firstdemo.dataClasses.ToDoData
import com.example.firstdemo.databinding.ActivityScrollViewBinding

/**
 * Description: This is the scrollview activity, And in this activity shows that how nested scrollview works.
 *
 * @author: Abhishek Oza.
 * @since: 7th March 2022.
 */

class ScrollViewActivity : AppCompatActivity() {
// This is data binding's variable, by its help we will execute all view's ids.
    private lateinit var binding : ActivityScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("ScrollView","onCreate() called.")
        var todoList = mutableListOf(

            ToDoData("Follow AndroidDevs",false),
            ToDoData("Follow hiii",false),
            ToDoData("Follow hello",false),
            ToDoData("Follow by",false)
        )

        val adapter = FirstAdapter(todoList)
        binding.firstRecycler.adapter = adapter
        binding.firstRecycler.layoutManager = LinearLayoutManager(this)



        binding.btnToDo.setOnClickListener(View.OnClickListener {


            val title = binding.editText.text.toString()
            val todo = ToDoData(title,false)

            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
        })
    }
}