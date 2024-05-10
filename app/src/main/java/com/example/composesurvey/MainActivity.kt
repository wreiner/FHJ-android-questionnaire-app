package com.example.composesurvey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
fun generateAnswerString(questions: List<Question>): String {
    return questions.filter {
        it.selectedAnswer != null
    }.map {
        stringResource(id = it.selectedAnswer!!)
    }.joinToString(", ")
}

@Composable
fun Questionnaire(questions: List<Question>, modifier: Modifier = Modifier) {
    Column {
        questions.forEach { question ->
            QuestionItem(question)
        }
        Spacer(modifier = modifier.padding(16.dp))
        Text(
            text = "Your answers: ${generateAnswerString(questions)}",
            modifier = modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun QuestionItem(question: Question, modifier: Modifier = Modifier) {
    Column () {
        Text(
            text = stringResource(id = question.text),
            modifier = modifier
                .padding(8.dp),
            fontWeight = FontWeight.Bold
        )

        question.answers.forEach { answer ->
            Row (
                modifier = Modifier.padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = question.selectedAnswer == answer, onClick = {
                    question.selectedAnswer = answer
                })
                Text(text = stringResource(id = answer))
            }
        }
    }
}
