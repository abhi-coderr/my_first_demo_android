package com.example.firstdemo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstdemo.databinding.FragmentTTBinding


class FragmentTT : Fragment() {

    private final lateinit var binding: FragmentTTBinding
    private var imgText: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTTBinding.inflate(layoutInflater)


        imgText = arguments?.getString("uri")

        binding.imgView.setImageURI(Uri.parse(imgText))


        return binding.root
    }


}