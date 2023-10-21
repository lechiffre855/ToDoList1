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
        private var editText: EditText = itemView.findViewById(R.id.et_what_need_to_be_done)
        private val addButton: Button = itemView.findViewById(R.id.bt_add)
        private val checkAll: Button = itemView.findViewById(R.id.bt_check_all)
        private val deleteCheckedButton: Button = itemView.findViewById(R.id.bt_delete_checked)
        private var checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        private var taskText: TextView = itemView.findViewById(R.id.tv_task_text)
        private var deleteButton: Button = itemView.findViewById(R.id.bt_delete)
        init {
            addButton.setOnClickListener(object : OnClickListener {
                override fun onClick(v: View?) {
                    Crud.add(editText.text.toString())
                    val toast = Toast.makeText(parent, Crud.addStatus, Toast.LENGTH_SHORT)
                    toast.show()
                }
            })
            checkAll.setOnClickListener(object: OnClickListener {
                override fun onClick(v: View?) {
                    Crud.checkAll()
                }
            })
            deleteCheckedButton.setOnClickListener(object: OnClickListener {
                override fun onClick(v: View?) {
                    Crud.deleteChecked()
                    val toast = Toast.makeText(parent, Crud.deleteCheckedStatus, Toast.LENGTH_SHORT)
                    toast.show()
                }
            })
            checkBox.setOnClickListener(object: OnClickListener {
                override fun onClick(v: View?) {
                    Crud.check(bindingAdapterPosition)
                }
            })
            deleteButton.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                    Crud.delete(bindingAdapterPosition)
                    val toast = Toast.makeText(parent, Crud.deleteStatus, Toast.LENGTH_SHORT)
                    toast.show()
                }
            })
        }
        fun bind(taskIndex: Int) {
            taskText.text = Crud.getTaskList()[taskIndex].getTextTask()
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