package com.example.bnzinterview.common.DI

import android.content.Context
import com.example.bnzinterview.common.networkConnectivityManager.NetworkConnectivityObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DINetworkConnectivityManager {

    @Provides
    fun provideNetworkConnectivityManager(@ApplicationContext context: Context): NetworkConnectivityObserver = NetworkConnectivityObserver(context)
}