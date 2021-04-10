package com.example.zadanie2.ui.foodIdea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.zadanie2.Calculator
import com.example.zadanie2.R

class FoodIdeaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_food_idea, container, false)
        val image = root.findViewById<ImageView>(R.id.foodImage)
        val calculator = Calculator()

        // get the BMI result from the BMI fragment
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val value = bundle.getString("bundleKey",R.string.error.toString())

            image.setImageResource(calculator.getImage(value))
            

        }

        return root
    }
}