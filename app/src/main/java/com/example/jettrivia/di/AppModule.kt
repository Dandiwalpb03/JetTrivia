package com.example.jettrivia.di

import com.example.jettrivia.network.QuestionAPI
import com.example.jettrivia.reopository.QuestionRepository
import com.example.jettrivia.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * This Singleton Object provide dependencies to Hilt DI System.
 * like: repository, Dao, class which instantiate Retrofit, etc.
 * */
@Module// used to indicate that a class provides dependencies to the Hilt dependency injection system.
@InstallIn(SingletonComponent::class) // this tells to module which component of the Hilt should be Installed.

object AppModule {


    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionAPI) = QuestionRepository(api)


    /**
     * this method uses the Retrofit library to create an instance of the "QuestionAPI" interface.
     * */
    @Singleton // indicates that the object returned by the method should be treated as a singleton.
    @Provides //  used in Hilt to indicate that the method provides an instance of an object.
    // that can be injected into other classes using Hilt.
    fun providesQuestionAPI(): QuestionAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)// to specify the base URL for the API
            .addConverterFactory(GsonConverterFactory.create())
            //this method is used to specify the converter factory that will be used to convert
            // the JSON response into a Kotlin object.
            .build()// to create the Retrofit instance
            .create(QuestionAPI::class.java)// method is used to create an instance of the "QuestionAPI" interface
    }

}