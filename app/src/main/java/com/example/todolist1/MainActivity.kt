package com.example.todolist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var taskList: RecyclerView
    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var checkAllButton: Button
    private lateinit var deleteCheckedButton: Button

    //    private lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Crud.setResources(this.resources)

        editText = findViewById(R.id.et_what_need_to_be_done)
        addButton = findViewById(R.id.bt_add)
        checkAllButton = findViewById(R.id.bt_check_all)
        deleteCheckedButton = findViewById(R.id.bt_delete_checked)

        addButton.setOnClickListener(InterfaceDispatcher(editText, this))
        checkAllButton.setOnClickListener(InterfaceDispatcher())
        deleteCheckedButton.setOnClickListener(InterfaceDispatcher())


        taskList = findViewById(R.id.rv_tasks)
        taskList.layoutManager = LinearLayoutManager(this)
        taskList.setHasFixedSize(true)

        taskList.adapter = TaskAdapter(this)
    }
}