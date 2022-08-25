package com.example.firstdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstdemo.dataClasses.ToDoData
import com.example.firstdemo.databinding.ItemTodoBinding

class FirstAdapter(var todo: List<ToDoData>) :
    RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstAdapter.FirstViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context))
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstAdapter.FirstViewHolder, position: Int) {
        holder.bind(todo[position])
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    inner class FirstViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(toDoData: ToDoData) {
            toDoData.apply {

                binding.apply {

                    tvTodo.text = title
                    cbTodo.isChecked

                }
            }

        }
    }
}