package com.example.composesurvey.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Question(
    val id: Int,
    val text: String,
    val answers: List<String>,
) {
    var selectedAnswer: String? by mutableStateOf(null)
}

