package com.example.workclass.ui.components

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TopBarComponent(title:String,navController: NavController, location:String){
    TopAppBar(
        title ={ Text (title)},
        actions = {
            if (location == "accounts_screen"){
                IconButton(onClick = {navController.navigate("favorite_accounts_screen")}) {
                    Icon (imageVector= Icons.Filled.Star,contentDescription = "Go to saved accounts")
            }
                IconButton(onClick = {navController.navigate("manage_account_screen")}) {
                    Icon (imageVector= Icons.Filled.Add,contentDescription = "Icon")
                }
            }
        }
    )
}