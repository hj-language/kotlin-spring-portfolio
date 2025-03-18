package com.hyejin.portfolio.admin.data

abstract class FormElementDTO(
    val name: String,
    val size: Int,
    val type: String,
)

class TextFormElementDTO(
    name: String,
    size: Int
) : FormElementDTO(name, size, "text")

class DateFormElementDTO(
    name: String,
    size: Int
) : FormElementDTO(name, size, "date")

class SelectFormElementDTO(
    name: String,
    size: Int,
    val options: List<Any>
) : FormElementDTO(name, size, "select")