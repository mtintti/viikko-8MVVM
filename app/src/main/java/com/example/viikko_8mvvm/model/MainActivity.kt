package com.example.viikko_8mvvm.model

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikko_8mvvm.ui.theme.Viikko8MVVMTheme
import com.example.viikko_8mvvm.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Viikko8MVVMTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { paddingValues ->
                        TodoScreen(modifier = Modifier.padding(paddingValues))
                    }
                )
            }
        }
    }
}



@Composable
fun TodoScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel = viewModel()) {
    TodoList(todoViewModel.todos, modifier)
}


@Composable
fun TodoList(todos: List<Todo>, modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                color = Color.Black
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Viikko8MVVMTheme {
        TodoScreen()
    }
}