package com.example.zadanie2.ui.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

import com.example.zadanie2.Calculator
import com.example.zadanie2.R

class BMIFragment : Fragment() {




    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bmi, container, false)
        val calculateButton = root.findViewById<Button>(R.id.calculateButton)
        val heightInput = root.findViewById<EditText>(R.id.heightInput)
        val weightInput = root.findViewById<EditText>(R.id.weightInput)
        val bmiResult = root.findViewById<TextView>(R.id.bmiResult)
        val calculator = Calculator()


        calculateButton.setOnClickListener {
            val height = heightInput.text.toString()
            val weight = weightInput.text.toString()
            val result = calculator.calculateBMI(height,weight)
            bmiResult.text = result

            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
        return root

    }
}