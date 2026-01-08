package com.aplussoft.todoapp.webapi

import com.aplussoft.todoapp.entity.Todo
import com.aplussoft.todoapp.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(@Autowired private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos(): List<Todo> = todoService.getAllTodos()

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Int): Todo? = todoService.getTodoById(id)

    @PostMapping
    fun createTodo(@RequestBody todo: Todo): Todo = todoService.createTodo(todo)

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Int, @RequestBody todo: Todo): Todo? = todoService.updateTodo(id, todo)

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Int) = todoService.deleteTodo(id)

}