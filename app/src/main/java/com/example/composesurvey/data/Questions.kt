package com.example.composesurvey.data

import com.example.composesurvey.R
import com.example.composesurvey.model.Question

val SurveyQuestions = listOf(
    Question(
        text = R.string.question_favorite_pet,
        answers = listOf(
            R.string.answer_favorite_pet_dog,
            R.string.answer_favorite_pet_cat
        )
    ),
    Question(
        text = R.string.question_preferred_hot_beverage,
        answers = listOf(
            R.string.answer_preferred_hot_beverage_coffee,
            R.string.answer_preferred_hot_beverage_tea,
            R.string.answer_preferred_hot_beverage_cocoa
        )
    ),
    Question(
        text = R.string.question_best_coding_language,
        answers = listOf(
            R.string.answer_best_coding_language_notjava,
            R.string.answer_best_coding_language_kotlin
        )
    )
)
