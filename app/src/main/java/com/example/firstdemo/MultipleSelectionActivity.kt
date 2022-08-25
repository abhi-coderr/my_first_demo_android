package com.example.firstdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstdemo.adapters.MAdapter
import com.example.firstdemo.dataClasses.MPojo
import com.example.firstdemo.databinding.ActivityMultipleSelectionBinding

/**
 * Description: This activity is the inner activity of RecyclerActivity.
 *
 * @author: Abhishek Oza.
 * @since: 8th March 2022.
 */

class MultipleSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultipleSelectionBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val names = listOf<MPojo>(



            MPojo("Abhishek",false),
            MPojo("Vikram",false),
            MPojo("Vashudev",false),
            MPojo("Virat",false),
            MPojo("Viren",false),
            MPojo("pandurank shastri",false),
            MPojo("Agatsya",false),
            MPojo("Eknaath",false),
            MPojo("chandra and mahipal",false),
            MPojo("nambi",false),
            MPojo("Shankracharya",false),
            MPojo("Atri",false),
            MPojo("krishna",false),
            MPojo("jigar",false),
            MPojo("ravi",false),
            MPojo("viram",false),
            MPojo("vidit",false),
            MPojo("Vasant",false)

        )


//      set the layout to the layoutManager
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        binding.multipleRecyclerView.layoutManager = layoutManager

        val adapter = MAdapter(this, names)
        binding.multipleRecyclerView.adapter = adapter





        adapter.notifyDataSetChanged()



        binding.doneButton.setOnClickListener(View.OnClickListener {


            val check= adapter.mModelList


            Toast.makeText(this,"Selected names are $check ✅",Toast.LENGTH_SHORT).show()


        })

    }
}