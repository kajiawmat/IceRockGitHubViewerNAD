package ru.nikolaev.icerockgithubviewer.error_types

sealed interface ApiError {
    data class NetworkError(val errorType: ErrorType?) : ApiError
    data class Error(val message: String?) : ApiError
}