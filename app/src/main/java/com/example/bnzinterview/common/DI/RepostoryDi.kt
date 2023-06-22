package com.example.bnzinterview.common.DI

import com.example.bnzinterview.featureDisplayListOfSchools.data.schoolRepository.SchoolRepository
import com.example.bnzinterview.featureDisplayListOfSchools.data.schoolRepository.SchoolRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryDI {

    @Binds
    fun provideSignInRepository(signinRepo: SchoolRepository): SchoolRepositoryInterface
}