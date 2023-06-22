package com.example.bnzinterview.featureDisplayListOfSchools.domain

object HttpRequestConstraints {

    private const val catalogueBaseUri = "https://catalogue.data.govt.nz"
    const val schoolData = "$catalogueBaseUri/api/3/action/datastore_search?resource_id=20b7c271-fd5a-4c9e-869b-481a0e2453cd&limit=20"
}