package com.example.zadanie2

import java.lang.Exception
import kotlin.math.pow
import kotlin.math.sqrt

enum class Gender {
    MALE, FEMALE
}

class Calculator {


    fun calculateBMI(height: String, weight: String): String {
        return try {
            String.format("%.2f", ((weight.toDouble() / (height.toDouble().pow(2))) * 10000))
        } catch (e: Exception) {
            R.string.error.toString();
        }
    }

    fun calculateBMR(height: String, weight: String, age:String, gender: Gender): String {
        return try {
            when (gender) {
                Gender.MALE -> {
                    String.format("%.2f", 66.5 + (13.75 * weight.toDouble()) + (5.003 * height.toDouble()) - (6.755 * age.toDouble()))
                }
                Gender.FEMALE -> {
                    String.format("%.2f", 655.1 + (9.563 * weight.toDouble()) + (1.85 * height.toDouble()) - (4.676 * age.toDouble()))
                }
            }

        } catch (e: Exception) {
            R.string.error.toString();
        }
    }

    fun getImage(value:String):Int {
        return try {
            when {
                value == R.string.error.toString() -> {
                    R.drawable.error
                }
                value.toDouble() < 20.0 -> {
                    R.drawable.burger
                }
                value.toDouble() in 20.0..24.0 -> {
                   R.drawable.schabowy
                }
                value.toDouble() > 24.0 -> {
                   R.drawable.salatka
                }
                else -> R.drawable.error
            }

        } catch (e: Exception) {
            R.drawable.error
        }
    }
}