package com.example.applicationforgravity.result

import java.lang.Exception

sealed class Result<out T>

data class Success<T>(val data: T?) : Result<T>()

data class Error(val ex: Exception) : Result<Nothing>()


inline fun <R> checkResultDetails(block: () -> R): Result<R> {
    return try {
        Success(block())
    }catch (ex:Exception){
        Error(ex)
    }
}