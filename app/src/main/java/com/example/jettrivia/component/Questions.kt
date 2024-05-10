package com.example.jettrivia.component

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.jettrivia.screens.QuestionViewModel


    @Composable
    fun Questions(viewModel: QuestionViewModel) {
        val questions = viewModel.dataFromViewModelClass.value.data?.toMutableList()
        if(viewModel.dataFromViewModelClass.value.loading == true){
            Log.d("Loading", "Question:.....Loading.....")
        }
        else{
            Log.d("Loading", "Question: Loading Stopped. ")
            questions?.forEach{ questionItem ->
                Log.d("Result", "Question:${questionItem.question}")
            }
        }


        // here data?.toMutableList() is used to convert the data to mutable list.
        // cause we have all the question in the arraylist.
        Log.d("Questions", "Questions: $questions?.size")
    }
