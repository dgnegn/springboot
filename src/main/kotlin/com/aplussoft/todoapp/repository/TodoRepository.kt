package com.aplussoft.todoapp.repository


import com.aplussoft.todoapp.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository


interface TodoRepository : JpaRepository<Todo, Int>

