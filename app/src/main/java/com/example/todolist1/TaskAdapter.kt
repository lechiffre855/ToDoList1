package com.example.todolist1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TaskAdapter(private val parent: Context): RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    inner class TaskHolder(@NonNull itemView: View): ViewHolder(itemView) {

        private var taskText: TextView = itemView.findViewById(R.id.tv_task_text)
        private var checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        private val deleteButton: Button = itemView.findViewById(R.id.bt_delete)

        init {
            checkBox.setOnClickListener(InterfaceDispatcher(bindingAdapterPosition))
        //            taskText.setOnClickListener(InterfaceDispatcher())
            // TODO
            deleteButton.setOnClickListener(InterfaceDispatcher(bindingAdapterPosition, parent))
        }
        fun bind(taskIndex: Int) {
            taskText.text = Crud.getTextCertainTask(taskIndex)
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
        return Crud.getTaskListSize()
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(position)
    }

}