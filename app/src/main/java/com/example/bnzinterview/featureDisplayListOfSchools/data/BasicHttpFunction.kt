package com.example.bnzinterview.featureDisplayListOfSchools.data.DI

import com.example.bnzinterview.featureDisplayListOfSchools.domain.HttpRequestConstraints
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import javax.inject.Inject

class BasicHttpRequests @Inject constructor(
    private val client: HttpClient,
) {
    suspend fun getListOfSchools(): String {
        return client.get(HttpRequestConstraints.schoolData) {
            contentType(ContentType.Application.Json)
        }.bodyAsText()
    }
}