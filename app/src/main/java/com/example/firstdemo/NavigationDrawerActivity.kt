package com.example.firstdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.viewpager.widget.ViewPager
import com.example.firstdemo.databinding.ActivityNavigationDrawerBinding
import com.example.firstdemo.databinding.ActivityViewPagerBinding

/**
 * Description: This is the activity class of the NavigationDrawerActivity,
 *              This is used to user for navigate in the app easily.
 *
 * @author: Abhishek Oza.
 * @since: 10th March 2022.
 */

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationDrawerBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toggle = ActionBarDrawerToggle(this, binding.navDrawerL, R.string.open, R.string.close)



        binding.navDrawerL.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navigationView.setNavigationItemSelectedListener {


            when (it.itemId) {

                R.id.navHome -> {
                    binding.bottomNav.selectedItemId = R.id.menuHome
                    binding.toolText.setText("Home")
                    binding.viewPager.currentItem = 0
                    binding.navDrawerL.closeDrawer(GravityCompat.START)
                }
                R.id.navMessages -> {
                    binding.toolText.setText("Messages")
                    binding.bottomNav.selectedItemId = R.id.menuMessage
                    binding.viewPager.currentItem = 1
                    binding.navDrawerL.closeDrawer(GravityCompat.START)
                }
                R.id.navProfile -> {

                    binding.toolText.setText("Profile")
                    binding.bottomNav.selectedItemId = R.id.menuPerson
                    binding.viewPager.currentItem = 2
                    binding.navDrawerL.closeDrawer(GravityCompat.START)

                }


            }
            true

        }


        fun onOptionsItemSelected(item: MenuItem): Boolean {

            if (toggle.onOptionsItemSelected(item)) {
                return true
            }
            return super.onOptionsItemSelected(item)
        }

        binding.viewPager.adapter = PageAdapter(supportFragmentManager)
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNav.selectedItemId = R.id.menuHome
                    1 -> binding.bottomNav.selectedItemId = R.id.menuMessage
                    2 -> binding.bottomNav.selectedItemId = R.id.menuPerson
                }

            }

            override fun onPageScrollStateChanged(state: Int) = Unit
        })




        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> {
                    binding.toolText.setText("Home")
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