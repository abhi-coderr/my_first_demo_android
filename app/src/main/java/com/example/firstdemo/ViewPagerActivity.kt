package com.example.firstdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.firstdemo.databinding.ActivityViewPagerBinding


/**
 *
 * Description: This the activity class of ViewPager, And this is used for Bottom navigation demo project.
 *
 * @author: Abhishek Oza.
 * @since: 9th March 2022.
 */


class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentFirst: Fragment = FirstFragment()

        binding.viewPager.adapter = PageAdapter(supportFragmentManager)



        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) =Unit

            override fun onPageSelected(position: Int) {
                when (position) {
                    0->binding.bottomNav.selectedItemId=R.id.menuHome
                    1->binding.bottomNav.selectedItemId=R.id.menuMessage
                    2->binding.bottomNav.selectedItemId=R.id.menuPerson
                }


            }

            override fun onPageScrollStateChanged(state: Int)=Unit
        })




        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> {
                    binding.toolText.setText("HOME")
                    binding.viewPager.currentItem = 0
                }
                R.id.menuMessage -> {
                    binding.toolText.setText("Message")
                    binding.viewPager.currentItem = 1
                }
                R.id.menuPerson -> {
                    binding.toolText.setText("My Profile")
                    binding.viewPager.currentItem = 2
                }

            }
            true
        }



    }


}