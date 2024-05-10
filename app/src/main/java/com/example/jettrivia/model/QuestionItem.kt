package com.example.jettrivia.model


/**
 * This data1 class holds the all the questions.*/
data class QuestionItem(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)