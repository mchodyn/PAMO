package com.example.zadanie2

class Quizer {
     var questionNumber = 0
     var score = 0
     var questions: Array<Question> = getQuizQuestions()

    fun startQuiz() {
        questionNumber = 0
        score = 0
        questions = getQuizQuestions()
    }

    private fun getQuizQuestions(): Array<Question> {
        return arrayOf(
            Question("test1", "a1", "a2", "a3", 1),
            Question("test2", "a1", "a2", "a3", 1),
            Question("test3", "a1", "a2", "a3", 1),
            Question("test4", "a1", "a2", "a3", 1)
        )
    }

    fun getCurrentQuestion(): Question{
        return questions[questionNumber]
    }

    fun addPoint(){
        score +=1
        questionNumber+=1
    }
    fun nextQuestion() {
        questionNumber+=1
    }
    fun isNextQuestionAvailable(): Boolean {
        return questions.lastIndex >= questionNumber
    }

    override fun toString(): String {
        return "Quizer(questionNumber=$questionNumber, score=$score, questions=${questions.contentToString()})"
    }


}