package com.example.jettrivia.network

import com.example.jettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton


// this will tell you what to do not how to do it, decrease coupling and increase cohesion.
@Singleton // using singleton because for app there should be only single sucrose of truth.
interface QuestionAPI {
    /**
     * this fun is asynchronous, suspendable, presumable because of coroutine
     * And this function will fetch the data1 in the background.*/
    @GET("/movies.json")
    suspend fun getQuestions(): Question

}