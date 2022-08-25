package com.example.firstdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstdemo.dataClasses.PojoClass
import com.example.firstdemo.databinding.StudentNameBinding

class MyAdapter(val list: List<PojoClass>) : RecyclerView.Adapter<MyAdapter.AdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.AdapterViewHolder {
        val binding = StudentNameBinding.inflate(LayoutInflater.from(parent.context))
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.AdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class AdapterViewHolder(private val binding: StudentNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pojo: PojoClass) {
            pojo.apply {
                binding.apply {

                    studentName.text = sname
                }
            }
        }
    }

}