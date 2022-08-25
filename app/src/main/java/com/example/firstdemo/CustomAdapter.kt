package com.example.firstdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstdemo.dataClasses.ItemsViewModel

/**
 * Description : This is the adapter class of recyclerview.
 *
 * @author : Abhishek Oza.
 * @since : 1st March 2022.
 */

class CustomAdapter(private val mList: List<ItemsViewModel>,
                    private val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.image.setImageResource(ItemsViewModel.image);

        holder.text.text = ItemsViewModel.text

        holder.itemView.setOnClickListener{
            onItemClickListener.onItemClickListener(position)
        }


    }

    override fun getItemCount(): Int {
        return mList.size;
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.imageview);
        val text: TextView = itemView.findViewById(R.id.textview);


    }

}

