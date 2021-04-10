package com.example.zadanie2.ui.bmr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.zadanie2.Calculator
import com.example.zadanie2.Gender
import com.example.zadanie2.R

class BMRFragment : Fragment() {

    private var gender = Gender.MALE

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bmr, container, false)
        val calculateButton = root.findViewById<Button>(R.id.calculate)
        val heightInput = root.findViewById<EditText>(R.id.heightInput)
        val weightInput = root.findViewById<EditText>(R.id.weightInput)
        val ageInput = root.findViewById<EditText>(R.id.ageInput)
        val bmrResult = root.findViewById<TextView>(R.id.bmrResult)
        val radioGroup = root.findViewById<RadioGroup>(R.id.radio_gender)
        val calculator = Calculator()


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.radio_male) {
                gender = Gender.MALE
            }
            if(checkedId == R.id.radio_female) {
                gender = Gender.FEMALE
            }
        }
        calculateButton.setOnClickListener {
            val height = heightInput.text.toString()
            val weight = weightInput.text.toString()
            val age = ageInput.text.toString()

            val result = calculator.calculateBMR(height,weight,age,gender)
            bmrResult.text = result
        }
        return root
    }
}