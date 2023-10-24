package com.example.todolist1

import android.content.Context
import android.content.res.Resources


class Crud {
    companion object {
        private var tasksList: MutableList<Task> = mutableListOf()
        private lateinit var resources: Resources

        fun setResources(resources: Resources) {
            this.resources = resources
        }

        fun getTaskListSize(): Int {
            return tasksList.size
        }

        fun getTextConcreteTask(index: Int): String {
            return tasksList[index].getTextTask()
        }

        lateinit var addStatus: String
        fun add(taskText: String) {
            if (taskText.isBlank())
                addStatus = resources.getString(R.string.add_smth)
            else {
                tasksList.add(0, Task(taskText))
                addStatus = resources.getString(R.string.task_added)
            }
        }

        lateinit var deleteStatus: String
        fun delete(index: Int) {
            if (tasksList[index].getActive() != true) {
                tasksList.removeAt(index)
                deleteStatus = resources.getString(R.string.task_deleted)
            } else {
                tasksList[index].setActive(false)
                deleteStatus = resources.getString(R.string.task_completed)
            }
        }

        lateinit var deleteCheckedStatus: String
        fun deleteChecked() {
            if (tasksList.any { it.getChecked() == true }) {
                tasksList.forEach {
                    if (it.getChecked() == true)
                        if (it.getActive() != true) {
                            tasksList.remove(it)
                        } else {
                            it.setActive(false)
                        }
                }
                deleteCheckedStatus = resources.getString(R.string.delete_checked_status_ok)
            } else
                deleteCheckedStatus = resources.getString(R.string.delete_checked_status_bad)
        }

        lateinit var editStatus: String
        fun edit(index: Int, text: String) {
            if (text.isNullOrBlank())
                editStatus = resources.getString(R.string.add_smth)
            else {
                tasksList[index].setTextTask(text)
                editStatus = resources.getString(R.string.task_added)
            }
        }

        fun check(index: Int){
            val currentStatus = tasksList[index].getChecked()
            tasksList[index].setChecked(!currentStatus)
        }

        var defaultCheckedStatus = false
        fun checkAll(){
            defaultCheckedStatus = !defaultCheckedStatus

            if (defaultCheckedStatus == true)
                tasksList.forEach {it.setChecked(true)}
            else
                tasksList.forEach {it.setChecked(false)}
        }
    }
}