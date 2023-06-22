package com.example.bnzinterview.featureDisplayListOfSchools.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bnzinterview.featureDisplayListOfSchools.domain.Record
import com.example.bnzinterview.featureDisplayListOfSchools.domain.SuccessState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolListScaffold(
    viewModel: SchoolListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {Text("SchoolApp")},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) {padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            when (val schoolList = viewModel.screenState.value) {
                is SuccessState.Success -> {
                    schoolList.data?.let { SchoolLazyList(it) }
                }
                is SuccessState.Failure -> {
                    Text("this failed sorry")
                }
                is SuccessState.Loading -> {
                    FullScreenProgress()
                }
            }
        }
    }
}

@Composable
fun SchoolLazyList(
    schoolList: List<Record>
) {
    LazyColumn(){
        items(schoolList
        ){school ->
            schoolCard(school)
        }
    }
}

@Composable
fun schoolCard(
    school: Record
) {
    val schoolID = school.School_Id.toString()
    val orgName = if(school.Org_Name ==""){"No Organisation Name Given"} else{school.Org_Name ?: "no OrgName"}
    val telephone = if(school.Telephone ==""){"No Telephone Given"} else{school.Telephone ?: "no Telephone"}
    val email = if(school.Email ==""){"No Email Given"} else{school.Email ?: "No Email"}

    Box(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(2.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column() {
            Text(modifier = Modifier.padding(4.dp),text = schoolID)
            Text(modifier = Modifier.padding(4.dp),text = orgName)
            Text(modifier = Modifier.padding(4.dp),text = telephone)
            Text(modifier = Modifier.padding(4.dp),text = email)
        }
    }
}

@Composable
fun FullScreenProgress() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}