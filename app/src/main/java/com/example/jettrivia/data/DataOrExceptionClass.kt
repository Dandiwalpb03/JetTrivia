package com.example.jettrivia.data

/**
 * This class will add additional info to the Question we are getting from the API.
 * @param T Generic data1 type to store the questions.
 * @param Boolean This boolean will tell us if data1 is loading or not.
 * @param E This will tell us if any exception arises.
 */
class DataOrExceptionClass<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: E? = null
)