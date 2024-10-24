package com.example.viikko_8mvvm.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viikko_8mvvm.model.Todo
import com.example.viikko_8mvvm.model.TodosApi
import kotlinx.coroutines.launch



class TodoViewModel : ViewModel() {
    var todos = mutableStateListOf<Todo>()
        private set

    init {
        Log.d("TodoViewModel", "ViewModel initialized, fetching todos...")
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val todosApi = TodosApi.getInstance()
                todos.clear()
                val fetchedTodos = todosApi.getTodos()
                todos.addAll(fetchedTodos)

            } catch (e: Exception) {
                Log.d("TodoViewModel", "Error fetching todos: ${e.message}")
            }
        }
    }
}
