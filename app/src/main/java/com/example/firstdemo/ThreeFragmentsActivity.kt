package com.example.firstdemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.firstdemo.databinding.ActivityThreeFragmentsBinding

/**
 * Description: This is the activity class of ThreeFragmentsActivity,
 *              And this is use for showing the demo of how fragments
 *              share data and navigate between them.
 *
 * @author Abhishek Oza.
 * @since 17th March 2022.
 */

class ThreeFragmentsActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityThreeFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.btnFirst.setOnClickListener {
//            replaceFragment(FragmentFT())
//        }
//
//        binding.btnSecond.setOnClickListener {
//            replaceFragment(FragmentST())
//        }
//
//        binding.btnThird.setOnClickListener {
//            replaceFragment(FragmentTT())
//
//        }


    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentThreeF, fragment).commit()
            addToBackStack(null)
        }


    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput)


        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentST = FragmentST()
        fragmentST.arguments = bundle

        transaction.replace(R.id.fragmentThreeF, fragmentST)

        transaction.commit()
    }

    override fun pussImage(imgUri: String) {
        val bundle = Bundle()
        bundle.putString("uri",imgUri)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTT= FragmentTT()
        fragmentTT.arguments = bundle

        transaction.replace(R.id.fragmentThreeF, fragmentTT)

        transaction.commit()


    }

    override fun pussProfile(name: String) { val bundle = Bundle()
        bundle.putString("profile",name)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTT= FragmentTT()
        fragmentTT.arguments = bundle

        transaction.replace(R.id.fragmentThreeF, fragmentTT)

        transaction.commit()

    }
}