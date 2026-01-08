package com.aplussoft.todoapp.service

import com.aplussoft.todoapp.entity.Todo
import com.aplussoft.todoapp.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(@Autowired private val todoRepository: TodoRepository) : TodoService {
    override fun getAllTodos(): List<Todo> = todoRepository.findAll()

    override fun getTodoById(id: Int): Todo? {
        return todoRepository.findById(id).orElseThrow {
            NoSuchElementException("Todo with id $id not found")
        }
    }

    override fun createTodo(todo: Todo): Todo {
        return todoRepository.save(
            Todo(
                title = todo.title,
                description = todo.description,
                done = todo.done
            )
        )

    }

    override fun updateTodo(
        id: Int,
        todo: Todo
    ): Todo {
        todoRepository.findById(id).orElseThrow {
            NoSuchElementException("Todo with id $id not found")
        }
        val updatedTodo = Todo(id, todo.title, todo.description, todo.done)

        return todoRepository.save(updatedTodo)
    }

    override fun deleteTodo(id: Int) {
        val idToBeDeleted = todoRepository.findById(id).orElseThrow {
            NoSuchElementException("Todo with id $id not found")
        }
        todoRepository.delete(idToBeDeleted)
    }

}