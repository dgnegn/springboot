package com.aplussoft.todoapp.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int= 0,
    @Column(unique = false, nullable = false)
    val title: String,
    @Column(unique = false, nullable = true)
    val description: String?,
    @Column(nullable = false)
    val done: Boolean
)
