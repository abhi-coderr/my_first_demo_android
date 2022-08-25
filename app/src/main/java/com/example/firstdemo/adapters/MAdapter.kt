package com.example.firstdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstdemo.dataClasses.MPojo
import com.example.firstdemo.databinding.LayoutMultiSelectionBinding


class MAdapter(val context: Context, val list: List<MPojo>) :
    RecyclerView.Adapter<MAdapter.MyViewHolder>() {


    val mModelList = ArrayList<String>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutMultiSelectionBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list[position]

        holder.bind(item, position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(private var binding: LayoutMultiSelectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pojo: MPojo, pos: Int) {
            pojo.apply {
                binding.apply {
                    layoutText.text = text
                    layoutCheckBox.isChecked = isSelected

                    layoutCheckBox.setOnClickListener(View.OnClickListener {

                        if (layoutCheckBox.isChecked) {
                                mModelList.add(text)
                                isSelected=true
                            }

                            if (!layoutCheckBox.isChecked) {
                                mModelList.remove(text)
                                isSelected=false
                            }

                    })
                }
            }


        }

    }
}