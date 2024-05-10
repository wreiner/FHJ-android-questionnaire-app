package com.example.composesurvey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composesurvey.data.SurveyQuestions
import com.example.composesurvey.model.Question
import com.example.composesurvey.ui.theme.ComposeSurveyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSurveyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Questionnaire(SurveyQuestions)
                }
            }
        }
    }
}

@Composable
fun Questionnaire(questions: List<Question>, modifier: Modifier = Modifier) {
    Column {
        questions.forEach { question ->
            QuestionItem(question)
        }
        Spacer(modifier = modifier)
        Text(
            text = "Your answers: ${questions.mapNotNull { it.selectedAnswer }.joinToString(", ")}"
        )
    }
}

@Composable
fun QuestionItem(question: Question, modifier: Modifier = Modifier) {
    Column () {
        Text(
            text = question.text,
            modifier = modifier
        )

        question.answers.forEach { answer ->
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = question.selectedAnswer == answer, onClick = {
                    question.selectedAnswer = answer
                })
                Text(text = answer)
            }
        }
    }
}
