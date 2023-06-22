package com.example.bnzinterview.featureDisplayListOfSchools.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bnzinterview.common.networkConnectivityManager.ConnectivityObserver
import com.example.bnzinterview.common.networkConnectivityManager.NetworkConnectivityObserver
import com.example.bnzinterview.common.DI.IoDispatcher
import com.example.bnzinterview.featureDisplayListOfSchools.data.schoolRepository.SchoolRepository
import com.example.bnzinterview.featureDisplayListOfSchools.domain.Record
import com.example.bnzinterview.featureDisplayListOfSchools.domain.SuccessState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(
    schoolRepository: SchoolRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    networkConnectivityObserver: NetworkConnectivityObserver,
): ViewModel() {

    private val _screenState = mutableStateOf <SuccessState<List<Record>>>(SuccessState.Loading())
    val screenState = _screenState

    private lateinit var networkState: Flow<ConnectivityObserver.Status>

    init {
        networkState = networkConnectivityObserver.observe()
        val scope = viewModelScope
        scope.launch (dispatcher) {
            _screenState.value = schoolRepository.getListOfSchools(networkState.first())
        }
    }
}