package com.example.todolist1

class Crud {
    companion object {
        private var tasksList: MutableList<Task> = mutableListOf()

        fun add(taskText: String): String {
            if (taskText.isNullOrBlank())
                return "Добавьте хотя бы один символ"
            else {
                tasksList.add(Task(taskText))
                return "Запись добавлена"
            }
        }
        fun delete(index: Int): String {
            if (tasksList[index].getActive()=true)
            tasksList.removeAt(index)
            return "Запись удалена"
        }
        fun deleteChecked() {
            tasksList.forEach {
                if {
                    it.getChecked() = true
                }

            }
        }
    }
}