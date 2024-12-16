package ara.hossein.androidtraining.onlinedictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ara.hossein.androidtraining.onlinedictionary.ui.theme.AndroidTraining_OnlineDictionaryTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTraining_OnlineDictionaryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DictionaryScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DictionaryScreen(modifier: Modifier = Modifier) {
    var word by remember { mutableStateOf("") }
    var meanings by remember { mutableStateOf(listOf<String>()) }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = word,
            onValueChange = { word = it },
            label = { Text("Enter a word") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                coroutineScope.launch {
                    meanings = fetchMeanings(word)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(meanings) { meaning ->
                Text(text = meaning, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

suspend fun fetchMeanings(word: String): List<String> {
    // Placeholder for API call to fetch meanings
    return listOf("Meaning 1", "Meaning 2", "Meaning 3")
}

@Preview(showBackground = true)
@Composable
fun DictionaryScreenPreview() {
    AndroidTraining_OnlineDictionaryTheme {
        DictionaryScreen()
    }
}
