package com.example.todolist1

data class Task(private var textTask: String) {
    private var checked: Boolean = false
    private var active: Boolean = true

    fun setChecked(status: Boolean) {
        checked = status
    }
    fun getChecked(): Boolean {
        return checked
    }
    fun setActive(status: Boolean) {
        active = status
    }
    fun getActive(): Boolean {
        return active
    }
}