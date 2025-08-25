package com.example.android14.practicainicial

import java.io.Serializable

data class Person(
    val name: String,
    val lastName: String,
    val email: String,
) : Serializable