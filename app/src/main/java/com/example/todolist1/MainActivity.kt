package com.example.todolist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var taskList: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskList = findViewById(R.id.rv_tasks)
//        val linearLayoutManager = LinearLayoutManager(this)
        taskList.layoutManager = LinearLayoutManager(this)
        taskList.setHasFixedSize(true)

    }
}