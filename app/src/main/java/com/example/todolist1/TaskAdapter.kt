package com.example.todolist1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TaskAdapter(private val parent: Context): RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    inner class TaskHolder(@NonNull itemView: View): ViewHolder(itemView) {

        private var taskText: TextView = itemView.findViewById(R.id.tv_task_text)
        fun bind(taskIndex: Int) {
            taskText.text = Crud.getTextConcreteTask(taskIndex)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
//        val context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val layoutForListItem = R.layout.task_content
        val view = inflater.inflate(layoutForListItem, parent, false)

        var taskHolder = TaskHolder(view)
        return taskHolder
    }

    override fun getItemCount(): Int {
        return Crud.getTaskList().size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(position)
    }

}