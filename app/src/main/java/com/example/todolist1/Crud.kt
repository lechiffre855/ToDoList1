package com.example.todolist1

class Crud {
    companion object {
        private var tasksList: MutableList<Task> = mutableListOf()

        fun getTaskListSize(): Int {
            return tasksList.size
        }

        fun getTextConcreteTask(index: Int): String {
            return tasksList[index].getTextTask()
        }

        lateinit var addStatus: String
        fun add(taskText: String) {
            if (taskText.isBlank())
                addStatus = "Добавьте хотя бы один символ"
            else {
                tasksList.add(Task(taskText))
                addStatus = "Запись добавлена"
            }
        }

        lateinit var deleteStatus: String
        fun delete(index: Int) {
            if (tasksList[index].getActive() != true) {
                tasksList.removeAt(index)
                deleteStatus = "Запись удалена"
            } else {
                tasksList[index].setActive(false)
                deleteStatus = "Запись выполнена"
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
                deleteCheckedStatus = "Успешно"
            } else
                deleteCheckedStatus = "Ни один элемент не помечен"
        }

        lateinit var editStatus: String
        fun edit(index: Int, text: String) {
            if (text.isNullOrBlank())
                editStatus = "Добавьте хотя бы один символ"
            else {
                tasksList[index].setTextTask(text)
                editStatus = "Запись добавлена"
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