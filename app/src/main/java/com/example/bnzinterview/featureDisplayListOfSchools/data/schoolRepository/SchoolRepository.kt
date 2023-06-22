package com.example.bnzinterview.featureDisplayListOfSchools.data.schoolRepository

import com.example.bnzinterview.common.networkConnectivityManager.ConnectivityObserver
import com.example.bnzinterview.featureDisplayListOfSchools.data.DI.BasicHttpRequests
import com.example.bnzinterview.featureDisplayListOfSchools.domain.Record
import com.example.bnzinterview.featureDisplayListOfSchools.domain.SchoolInformation
import com.example.bnzinterview.featureDisplayListOfSchools.domain.SuccessState
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject


class SchoolRepository @Inject constructor(
    private val basicHttpRequests: BasicHttpRequests,
):  SchoolRepositoryInterface {

    private var json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    override suspend fun getListOfSchools(status: ConnectivityObserver.Status): SuccessState<List<Record>> {

        if (status != ConnectivityObserver.Status.Available) {
            return SuccessState.Failure("")
        }
        val token = basicHttpRequests.getListOfSchools()
        val schoolList = json.decodeFromString<SchoolInformation>(token).result.records
        return SuccessState.Success(schoolList)
    }
}