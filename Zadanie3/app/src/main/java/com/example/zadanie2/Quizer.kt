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
            Question("Ile posiłków dziennie powinno się jeść?", "2", "3", "5", 2),
            Question("Ile litrów wody powinno się pić w ciągu dnia?", "1", "2", "12", 1),
            Question("Który z posiłków jest najważniejszy?", "Śniadanie", "Obiad", "Kolacja", 0),
            Question("Co ile godzin powinno się spożywać posiłki?", "1-2", "3-4", "6-7", 1),
            Question("Ile godzin snu potrzebuje przeciętny człowiek?", "4-6", "9-10", "6-8", 2),
            Question("W jakim wieku powinno się przestrzegać zasad zdrowego odżywiania się?", "Za młodu", "Na starość", "zawsze", 2)
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