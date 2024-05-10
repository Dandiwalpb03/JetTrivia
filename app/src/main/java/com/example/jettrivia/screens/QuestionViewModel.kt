package com.example.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.data.DataOrExceptionClass
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.reopository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// When a class is annotated with "@Inject", Hilt can automatically provide instances of
// that class( QuestionViewModel class )  to other classes that depend on it.
/**
 * ViewModel is to manage and handle UI data1 like here we are getting questions.*/
@HiltViewModel // Hilt can automatically provide instances of a ViewModel to other classes that depend on it.
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {
    public val dataFromViewModelClass: MutableState<DataOrExceptionClass<ArrayList<QuestionItem>, Boolean, Exception>>
    = mutableStateOf(DataOrExceptionClass(null, true, Exception(""))) // this data1 hold


    init {
        getAllQuestions()
    }
    /**Fetches all the questions from the repository using a coroutine scope.
     * and updates the data1 state with the fetched questions.*/

    private fun getAllQuestions(){
        viewModelScope.launch {
            // This launches a new coroutine in the context of the viewModelScope.
            // This ensures that the coroutine will be automatically canceled
            // (it can be cancelled in the middle of the coroutine request) when the view model is cleared.
            dataFromViewModelClass.value.loading = true
            dataFromViewModelClass.value = repository.getAllQuestions()
            if (dataFromViewModelClass.value.data.toString().isNotEmpty()){
                dataFromViewModelClass.value.loading = false
            }

        }
    }
}