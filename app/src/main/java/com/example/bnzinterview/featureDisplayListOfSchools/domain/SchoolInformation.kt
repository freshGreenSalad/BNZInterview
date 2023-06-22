package com.example.bnzinterview.featureDisplayListOfSchools.domain

import kotlinx.serialization.Serializable

@Serializable
data class SchoolInformation(
    val help: String,
    val result: Result,
    val success: Boolean
)
@Serializable
data class Result(
    val _links: Links,
    val fields: List<Field>,
    val include_total: Boolean,
    val limit: Int,
    val records: List<Record>,
    val records_format: String,
    val resource_id: String,
    val total: Int,
    val total_estimation_threshold: String?,
    val total_was_estimated: Boolean
)

@Serializable
data class Links(
    val next: String,
    val start: String
)
@Serializable
data class Field(
    val id: String,
    val type: String
)
@Serializable
data class Record(
    val Add1_City: String?,
    val Add1_Line1: String?,
    val Add1_Suburb: String?,
    val Add2_City: String?,
    val Add2_Line1: String?,
    val Add2_Postal_Code: Int?,
    val Add2_Suburb: String?,
    val Area_Unit: String?,
    val Asian: Int?,
    val Authority: String?,
    val CoEd_Status: String?,
    val Col_Id: Int?,
    val Col_Name: String?,
    val Contact1_Name: String?,
    val Decile: String?,
    val Definition: String?,
    val Education_Region: String?,
    val Email: String?,
    val European: Int?,
    val Fax: String?,
    val General_Electorate: String?,
    val International: Int?,
    val Isolation_Index: String?,
    val Latitude: Double?,
    val Local_Office_Name: String?,
    val Longitude: Double?,
    val MELAA: Int?,
    val Māori: Int? = null,
    val Māori_Electorate: String? = null,
    val Org_Name: String?,
    val Org_Type: String?,
    val Other: Int?,
    val Pacific: Int?,
    val Regional_Council: String?,
    val Roll_Date: String?,
    val School_Donations: String?,
    val School_Id: Int?,
    val Telephone: String?,
    val Territorial_Authority: String?,
    val Total: Int?,
    val URL: String?,
    val Urban_Area: String?,
    val Ward: String?,
    val _id: Int?
)