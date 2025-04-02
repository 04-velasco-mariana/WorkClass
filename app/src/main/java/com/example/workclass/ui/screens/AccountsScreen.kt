package com.example.workclass.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.viewmodel.AccountViewModel
import com.example.workclass.data.viewmodel.UserViewModel
import com.example.workclass.ui.components.AccountCardComponent
import com.example.workclass.ui.components.TopBarComponent

@Composable
fun AccountsScreen (
    navController: NavController,
    viewModel: AccountViewModel= viewModel()
){
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList())}

    Column {
        TopBarComponent("Accounts")
        LaunchedEffect(Unit) {
           viewModel.getAccounts { response ->
               if (response.isSuccessful){
                   accounts= response.body()?: emptyList()
               } else {
                   Log.d("debug", "Failed to load data")
               }
           }
        }
        //AccountCardComponent(1,"name", "user@gmail.com", "")
    }
}