package com.example.decisionmakingapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import kotlin.random.Random

class Click(
    val probabilityNum: Int,
    val text: String
) {
    var clicknum by mutableIntStateOf(0)


    fun probability():Int {
        val randomNum = Random.nextInt(1, 101)
        if (randomNum > probabilityNum) {
            return 0
        }
        else{
            return 1
        }
    }

    fun addClick () {
        clicknum += 1
    }


}