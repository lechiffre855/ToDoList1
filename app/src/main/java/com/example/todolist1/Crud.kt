package com.example.todolist1

class Crud {
    companion object {
        private val tasksList: MutableList<Task> = mutableListOf()

        lateinit var addStatus: String
        fun add(taskText: String) {
            if (taskText.isNullOrBlank())
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

        fun edit(index: Int, text: String): String {
            if (text.isNullOrBlank())
                return "Добавьте хотя бы один символ"
            else {
                tasksList[index].setTextTask(text)
                return "Запись добавлена"
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