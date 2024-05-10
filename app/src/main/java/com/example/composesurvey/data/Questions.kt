package com.example.composesurvey.data

import com.example.composesurvey.model.Question

val SurveyQuestions = listOf(
    Question(
        id = 0,
        text = "Question 1",
        answers = listOf("Q1A1", "Q1A2")
    ),
    Question(
        id = 1,
        text = "Question 2",
        answers = listOf("Q2A1", "Q2A2", "Q2A3")
    ),
    Question(
        id = 2,
        text = "Question 3",
        answers = listOf("Q3A1", "Q3A2", "Q3A3")
    )
)
