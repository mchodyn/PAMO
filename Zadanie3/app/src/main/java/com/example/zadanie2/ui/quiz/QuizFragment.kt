package com.example.zadanie2.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.zadanie2.Quizer
import com.example.zadanie2.R

class QuizFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_quiz, container, false)
        val startBtn = root.findViewById<Button>(R.id.quizStart)
        val nextBtn = root.findViewById<Button>(R.id.quizNext)
        val question = root.findViewById<TextView>(R.id.quizQuestion)
        val title = root.findViewById<TextView>(R.id.quizTitle)
        val result = root.findViewById<TextView>(R.id.quizResult)
        val score = root.findViewById<TextView>(R.id.quizScore)
        val radioGroup = root.findViewById<RadioGroup>(R.id.quizRadio)
        val answer1 = root.findViewById<RadioButton>(R.id.answer1)
        val answer2 = root.findViewById<RadioButton>(R.id.answer2)
        val answer3 = root.findViewById<RadioButton>(R.id.answer3)


        val quizer = Quizer()

        fun writeQuestion() {
            val currentQuestion = quizer.getCurrentQuestion()
            question.text = currentQuestion.question
            answer1.text = currentQuestion.answer1
            answer2.text = currentQuestion.answer2
            answer3.text = currentQuestion.answer3
        }

        fun showResult() {
            nextBtn.visibility = View.GONE
            question.visibility = View.GONE
            radioGroup.visibility = View.GONE
            result.visibility = View.VISIBLE
            score.visibility = View.VISIBLE
            score.text = quizer.score.toString()

        }

        fun checkQuestion() {
            val checked = radioGroup.checkedRadioButtonId
            if (checked != -1) {
                val radioButton: View = radioGroup.findViewById(checked)
                val idx: Int = radioGroup.indexOfChild(radioButton)
                val properAnswer = quizer.getCurrentQuestion().properAnswerIndex
                when (properAnswer == idx) {
                    true -> quizer.addPoint()
                    false -> quizer.nextQuestion()
                }
                when (quizer.isNextQuestionAvailable()) {
                    true -> writeQuestion()
                    false -> showResult()
                }

            }
        }

        startBtn.setOnClickListener {
            quizer.startQuiz()
            title.visibility = View.GONE
            startBtn.visibility = View.GONE
            nextBtn.visibility = View.VISIBLE
            question.visibility = View.VISIBLE
            radioGroup.visibility = View.VISIBLE
            writeQuestion()

        }

        nextBtn.setOnClickListener {
            checkQuestion()
        }

        return root
    }
}