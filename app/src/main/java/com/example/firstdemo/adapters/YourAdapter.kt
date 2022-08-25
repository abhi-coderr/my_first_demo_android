package com.example.firstdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstdemo.dataClasses.NewPojo
import com.example.firstdemo.databinding.StudentNameBinding

class YourAdapter {
    class MyAdapter(val plist: List<NewPojo>) :
        RecyclerView.Adapter<MyAdapter.AdapterViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyAdapter.AdapterViewHolder {
            val binding = StudentNameBinding.inflate(LayoutInflater.from(parent.context))
            return AdapterViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MyAdapter.AdapterViewHolder, position: Int) {
            holder.bind(plist[position])
        }

        override fun getItemCount(): Int {
            return plist.size
        }

        inner class AdapterViewHolder(private val binding: StudentNameBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(pojo: NewPojo) {
                pojo.apply {
                    binding.apply {

                        studentName.text = pname
                    }
                }
            }
        }

    }
}