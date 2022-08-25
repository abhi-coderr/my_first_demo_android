package com.example.firstdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.firstdemo.databinding.FragmentFTBinding


class FragmentFT : Fragment() {

    private final lateinit var binding : FragmentFTBinding

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        communicator = activity as Communicator


        binding = FragmentFTBinding.inflate(layoutInflater)


        binding.btnDone.setOnClickListener {

            communicator.passDataCom(binding.etFirst.text.toString())

        }




        return binding.root
    }


}