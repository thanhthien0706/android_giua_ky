package com.example.giuaky

import java.io.Serializable

data class Tinh(
    val resouerceId: Int,
    val name: String,
    val population: String,
    val description: String
) : Serializable