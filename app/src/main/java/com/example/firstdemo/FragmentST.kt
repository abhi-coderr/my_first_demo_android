package com.example.firstdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.firstdemo.databinding.FragmentFTBinding
import com.example.firstdemo.databinding.FragmentSTBinding


class FragmentST : Fragment() {
    private final lateinit var binding: FragmentSTBinding
    private var inputText: String? = ""
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        communicator = activity as Communicator



        binding = FragmentSTBinding.inflate(layoutInflater)





        inputText = arguments?.getString("message")





        binding.inputstring.text = inputText



        binding.btnImg.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)

                startActivity(it)

            }
        }


        return binding.root
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == 0) {
            val uri = data?.data.toString()



                communicator.pussImage(uri)


        }
    }

}