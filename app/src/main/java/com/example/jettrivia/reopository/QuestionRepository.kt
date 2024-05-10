package com.example.jettrivia.reopository

import android.util.Log
import com.example.jettrivia.data.DataOrExceptionClass
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.network.QuestionAPI
import javax.inject.Inject

// When a class is annotated with "@Inject", Hilt can automatically provide instances of
// that class(QuestionRepository class )  to other classes that depend on it.
/**In the code you provided, the constructor of the "QuestionRepository" class is annotated with "@Inject".
This means that Hilt can automatically provide an instance of the "QuestionRepository" class to other classes that depend on it.*/
class QuestionRepository @Inject constructor(
    private val api: QuestionAPI
    //The constructor takes a single parameter of type "QuestionAPI", which is also annotated with "@Inject".
    //This means that Hilt can automatically provide an instance of the "QuestionAPI" interface
    // to the constructor of the "QuestionRepository" class
) {

    // In this way you can get data1 but we can't know some additional information about is data1 loading
    // or there any error occurred while loading and which exception rises.
    //    private val listOfQuestions = ArrayList<QuestionItem>(emptyList())
    // So we Introduced new Data Class called DataOrException which will fill the gap between
    // our need and what we are getting from the above method of getting data1

    private val dataOrException = DataOrExceptionClass<ArrayList<QuestionItem>,
            Boolean,
            Exception>()

    suspend fun getAllQuestions(): DataOrExceptionClass<ArrayList<QuestionItem>, Boolean, Exception> {
        // DataOrException<ArrayList<QuestionItem>, Boolean, Exception> this the return type fo this function.
        try {
            dataOrException.loading = true
            dataOrException.data = api.getQuestions() // getQuestions will fetch the data1 and
            // assign to data1 (to ArrayList<QuestionItem>)
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        }
        catch (exception: Exception){
            dataOrException.exception = exception
            Log.d("Exc", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")
        }
        return dataOrException
    }


}