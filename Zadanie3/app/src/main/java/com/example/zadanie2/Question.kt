package com.example.zadanie2

class Question(
    var question: String, var answer1: String, var answer2: String,
    var answer3: String, var properAnswer: Number
) {
    override fun toString(): String {
        return "Question(question='$question', answer1='$answer1', answer2='$answer2', answer3='$answer3', properAnswer=$properAnswer)"
    }
}