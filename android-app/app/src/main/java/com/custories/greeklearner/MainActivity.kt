package com.custories.greeklearner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreekLearnerTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreekLearnerApp()
                }
            }
        }
    }
}

data class Lesson(
    val title: String,
    val greek: String,
    val transliteration: String,
    val meaning: String,
    val tip: String
)

@Composable
fun GreekLearnerApp() {
    val lessons = remember {
        listOf(
            Lesson(
                title = "Greetings",
                greek = "Γειά σου",
                transliteration = "Yah soo",
                meaning = "Hello (informal)",
                tip = "Use with friends and family."
            ),
            Lesson(
                title = "Polite hello",
                greek = "Καλημέρα",
                transliteration = "Kah-lee-MEH-rah",
                meaning = "Good morning",
                tip = "Use before noon as a polite greeting."
            ),
            Lesson(
                title = "Thank you",
                greek = "Ευχαριστώ",
                transliteration = "Ef-hah-ree-STOH",
                meaning = "Thank you",
                tip = "Say this anytime you want to show appreciation."
            ),
            Lesson(
                title = "Ordering",
                greek = "Θα ήθελα...",
                transliteration = "Tha EE-the-la",
                meaning = "I would like...",
                tip = "Great starter phrase for cafés or shops."
            )
        )
    }

    var dailyGoal by remember { mutableStateOf(10) }
    var minutesLogged by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "Greek Learner",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Daily focus: ${"%d".format(minutesLogged)} / $dailyGoal minutes",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProgressCard(minutesLogged = minutesLogged, dailyGoal = dailyGoal) {
            if (minutesLogged < dailyGoal) {
                minutesLogged += 1
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Today’s bite-size lessons",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(lessons) { lesson ->
                LessonCard(lesson = lesson)
            }
        }
    }
}

@Composable
fun ProgressCard(minutesLogged: Int, dailyGoal: Int, onQuickPractice: () -> Unit) {
    val progress = (minutesLogged.toFloat() / dailyGoal.coerceAtLeast(1))
    val progressColor = if (progress >= 1f) Color(0xFF4CAF50) else MaterialTheme.colorScheme.primary

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Daily practice",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.headlineSmall,
                    color = progressColor,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = onQuickPractice) {
                    Text(text = "+1 minute")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Keep a streak by practicing a little every day.",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun LessonCard(lesson: Lesson) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = lesson.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = lesson.greek,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(text = lesson.transliteration, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = lesson.meaning, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = lesson.tip, style = MaterialTheme.typography.bodySmall)
        }
    }
}
