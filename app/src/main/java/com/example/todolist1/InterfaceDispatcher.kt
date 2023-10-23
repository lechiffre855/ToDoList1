package com.example.todolist1

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InterfaceDispatcher: OnClickListener {

    private lateinit var editText: EditText
    private lateinit var parent: Context
    private var bindingAdapterPosition: Int = 0

    constructor(parent: Context) {
        this.parent = parent
    }
    constructor(editText: EditText, parent: Context) {
        this.editText = editText
        this.parent = parent
    }
    constructor(bindingAdapterPosition: Int) {
        this.bindingAdapterPosition = bindingAdapterPosition
    }
    constructor(bindingAdapterPosition: Int, parent: Context) {
        this.bindingAdapterPosition = bindingAdapterPosition
        this.parent = parent
    }
    constructor(){
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_add -> {
                Crud.add(editText.text.toString())
                val toast = Toast.makeText(parent, Crud.addStatus, Toast.LENGTH_SHORT)
                toast.show()
            }
            R.id.bt_check_all -> {
                Crud.checkAll()
            }
            R.id.bt_delete_checked -> {
                Crud.deleteChecked()
                val toast = Toast.makeText(parent, Crud.deleteCheckedStatus, Toast.LENGTH_SHORT)
                toast.show()
            }
            R.id.checkBox -> {
                Crud.check(bindingAdapterPosition)
            }

            R.id.bt_delete -> {
                Crud.delete(bindingAdapterPosition)
                val toast = Toast.makeText(parent, Crud.deleteStatus, Toast.LENGTH_SHORT)
                toast.show()
            }
//            R.id.tv_task_text -> {
//                Crud.edit(index, String)
//                val toast = Toast.makeText(parent, Crud.editStatus, Toast.LENGTH_SHORT)
//                toast.show()
//            }
        }
    }
}