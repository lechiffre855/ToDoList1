package com.example.todolist1

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class InterfaceDispatcher {
    val TaskAdapter.TaskHolder.get

    private var editText: EditText = itemView.findViewById(R.id.et_what_need_to_be_done)
    private val addButton: Button = itemView.findViewById(R.id.bt_add)
    private val checkAll: Button = itemView.findViewById(R.id.bt_check_all)
    private val deleteCheckedButton: Button = itemView.findViewById(R.id.bt_delete_checked)
    private var checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    private var deleteButton: Button = itemView.findViewById(R.id.bt_delete)

    addButton.setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View?) {
            Crud.add(editText.text.toString())
            val toast = Toast.makeText(parent, Crud.addStatus, Toast.LENGTH_SHORT)
            toast.show()
        }
    })
    checkAll.setOnClickListener(object: View.OnClickListener {
        override fun onClick(v: View?) {
            Crud.checkAll()
        }
    })
    deleteCheckedButton.setOnClickListener(object: View.OnClickListener {
        override fun onClick(v: View?) {
            Crud.deleteChecked()
            val toast = Toast.makeText(parent, Crud.deleteCheckedStatus, Toast.LENGTH_SHORT)
            toast.show()
        }
    })
    checkBox.setOnClickListener(object: View.OnClickListener {
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