package com.aplussoft.todoapp.service

import com.aplussoft.todoapp.entity.Todo

interface TodoService {
    fun getAllTodos(): List<Todo>
    fun getTodoById(id: Int): Todo?
    fun createTodo(todo: Todo): Todo
    fun updateTodo(id: Int, todo: Todo): Todo
    fun deleteTodo(id: Int)
}