package com.example.bnzinterview.featureDisplayListOfSchools.data.schoolRepository

import com.example.bnzinterview.common.networkConnectivityManager.ConnectivityObserver
import com.example.bnzinterview.featureDisplayListOfSchools.domain.Record
import com.example.bnzinterview.featureDisplayListOfSchools.domain.SuccessState

interface SchoolRepositoryInterface {
    suspend fun getListOfSchools(status : ConnectivityObserver.Status): SuccessState<List<Record>>
}