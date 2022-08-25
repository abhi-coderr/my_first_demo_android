package com.example.firstdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstdemo.dataClasses.ItemsViewModel
import com.example.firstdemo.databinding.ActivityMainBinding

/**
 * Description : This is the main activity of this application, And this is the entrance of the application.
 *
 * @author : Abhishek Oza.
 * @since : 1st March 2022.
 */

class MainActivity : AppCompatActivity(), OnItemClickListener {

    //        ViewBinding is used for crate references for id's of views.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        this creates a vertical layout manager


//        Arraylist of class ItemsViewHolder
        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "TextView"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "Button"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "EditText"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "AppCompatSwitch"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "RadioButton"))
        data.add(
            ItemsViewModel(
                R.drawable.ic_baseline_create_new_folder_24,
                "Layouts & SharedPreferences"
            )
        )
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "Progress View"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "Scrollview"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "RecyclerView"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "ViewPager"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "BottomBar"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "Navigation Drawer"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "3 Activity"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "3 Fragments"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "WebView"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "MapView"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "World of permissions"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "Spinner"))
        data.add(ItemsViewModel(R.drawable.ic_baseline_create_new_folder_24, "RatingBAr"))

        val adapter = CustomAdapter(mList = data, onItemClickListener = this)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        adapter.notifyDataSetChanged()


    }

    override fun onItemClickListener(postion: Int) {
        Toast.makeText(this, "clicked$postion", Toast.LENGTH_SHORT).show()
        when (postion) {
            0 -> {
                val intent: Intent = Intent(this, TextView_Activity::class.java)
                startActivity(intent)
            }
            1 -> {
                val intent: Intent = Intent(this, Button_Activity::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent: Intent = Intent(this, EditText_Activity::class.java)
                startActivity(intent)

            }
            3 -> {
                val intent: Intent = Intent(this, AppCompatSwitch_Activity::class.java)
                startActivity(intent)
            }
            4 -> {
                val intent: Intent = Intent(this, RadioButtonActivity::class.java)
                startActivity(intent)

            }
            // shared preferences and layout
            5 -> {
                val intent: Intent = Intent(this, AllLayoutsActivity::class.java)
                startActivity(intent)


            }
            6 -> {
                val intent: Intent = Intent(this, ProgressActivity::class.java)
                startActivity(intent)
            }
            7 -> {
                val intent: Intent = Intent(this, ScrollViewActivity::class.java)
                startActivity(intent)
            }
            8 -> {
                val intent: Intent = Intent(this, RecyclerActivity::class.java)
                startActivity(intent)
            }
//          ViewPager
            9 -> {
                val intent: Intent = Intent(this, ViewPagerActivity::class.java)
                startActivity(intent)
//          BottomBar
            }
            10 -> {
                val intent: Intent = Intent(this, BottomNavigationActivity::class.java)
                startActivity(intent)
            }
//          NavigationDrawer
            11 -> {
                val intent: Intent = Intent(this, NavigationDrawerActivity::class.java)
                startActivity(intent)
            }
//          3 Activity
            12 -> {
                val intent: Intent = Intent(this, ThreeActivity::class.java)
                startActivity(intent)
            }
//          3 Fragments
            13 -> {
                val intent: Intent = Intent(this, ThreeFragmentsActivity::class.java)
                startActivity(intent)
            }
//          WebView
            14 -> {
                val intent: Intent = Intent(this, WebViewActivity::class.java)
                startActivity(intent)
            }
//          MapView
            15 -> {
                val intent: Intent = Intent(this, GoogleMapActivity::class.java)
                startActivity(intent)
            }
//          permission
            16 -> {
                val intent: Intent = Intent(this, AskPermissionsActivity::class.java)
                startActivity(intent)
            }
//          Spinner
            17 -> {
                val intent: Intent = Intent(this, SpinnerActivity::class.java)
                startActivity(intent)
            }
//          RatingBar
            18 -> {
                val intent: Intent = Intent(this, RatingBarActivity::class.java)
                startActivity(intent)
            }
            else -> {
                val intent: Intent = Intent(this, TextView_Activity::class.java)
            }
        }

    }

}