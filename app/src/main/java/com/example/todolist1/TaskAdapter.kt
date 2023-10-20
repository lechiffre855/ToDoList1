package com.example.todolist1

import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    inner class TaskHolder(@NonNull itemView: View): ViewHolder(itemView) {
        private var taskText: TextView = itemView.findViewById(R.id.tv_task_text)
        private var checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        private var deleteButton: Button = itemView.findViewById(R.id.bt_delete)
        private var editText: EditText = itemView.findViewById(R.id.et_what_need_to_be_done)
        private val checkAll: Button = itemView.findViewById(R.id.bt_check_all)
        init {
            deleteButton.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                    Crud.delete(bindingAdapterPosition)
                    val toast = Toast.makeText(parent, Crud.deleteStatus, Toast.LENGTH_SHORT)
                    toast.show()
                }
            })
            checkBox.setOnClickListener(object: OnClickListener {
                override fun onClick(v: View?) {
                    Crud.check(bindingAdapterPosition)
                }
            })
            checkAll.setOnClickListener(object: OnClickListener {
                override fun onClick(v: View?) {
                    Crud.checkAll()
                }
            })
        }
        fun bind(taskIndex: Int) {
            taskText.text = taskIndex.toString()+ ". " + editText.text.toString()
        }
    }

}