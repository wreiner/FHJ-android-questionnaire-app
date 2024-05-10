package com.example.composesurvey.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Question(
    val text: Int,
    val answers: List<Int>,
) {
    var selectedAnswer: Int? by mutableStateOf(null)
}

