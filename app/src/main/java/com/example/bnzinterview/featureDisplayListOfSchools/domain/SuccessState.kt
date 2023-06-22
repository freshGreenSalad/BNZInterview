package com.example.bnzinterview.featureDisplayListOfSchools.domain

sealed class SuccessState<T> (val data: T? = null, val error: String? = null){
    class Failure<T>(error: String? = null): SuccessState<T>(error = error)
    class Success<T>(data: T): SuccessState<T>(data = data)
    class Loading<T>(): SuccessState<T>()
}