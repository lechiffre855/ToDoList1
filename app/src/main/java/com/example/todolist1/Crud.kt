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
            if (tasksList[index].getActive() != true) {
                tasksList.removeAt(index)
                return "Запись удалена"
            } else {
                tasksList[index].setActive(false)
                return "Запись выполнена"
            }
        }

        fun deleteChecked(): String {
            tasksList.forEach {
                if (it.getChecked() == true)
                    if (it.getActive() != true) {
                        tasksList.remove(it)
                    } else {
                        it.setActive(false)
                    }
            }
            return "Успешно"
        }

        fun edit(index: Int, text: String): String {
            if (text.isNullOrBlank())
                return "Добавьте хотя бы один символ"
            else {
                tasksList[index].setTextTask(text)
                return "Запись добавлена"
            }
        }
    }
}