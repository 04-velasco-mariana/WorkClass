package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen (navController: NavHostController){
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()

    ){
        Text("Home Screen")
        Button(
            onClick = {navController.navigate("main_menu")}
        ) {
            Text("Return to Main Menu")
        }
        Button(
            onClick = {navController.navigate("test_screen")}
        ) {
            Text("Return to Test Screen")
        }


    }

}
