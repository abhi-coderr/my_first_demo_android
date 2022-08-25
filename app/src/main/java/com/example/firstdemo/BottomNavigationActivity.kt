package com.example.firstdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.firstdemo.databinding.ActivityBottomNavigationBinding
import com.example.firstdemo.databinding.ActivityViewPagerBinding

class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()

        val secondFragment = SecondFragment()

        val thirdFragment = ThirdFragment()

        setCurrentFunction(firstFragment)
        binding.toolText.setText("Home")

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> {setCurrentFunction(firstFragment)
                    binding.toolText.setText("Home")
                }
                R.id.menuMessage -> {setCurrentFunction(secondFragment)
                    binding.toolText.setText("Message")
                }
                R.id.menuPerson -> {setCurrentFunction(thirdFragment)
                    binding.toolText.setText("My Profile")
                }
            }
            true
        }

    }

    private fun setCurrentFunction(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }

}