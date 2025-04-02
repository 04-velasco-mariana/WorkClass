package com.example.workclass.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass.R


@Composable
fun MainMenuScreen (navController: NavHostController){
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()

    ){
        Text(" Welcome to Main menu")
        Button(
            onClick = { navController.navigate("home_screen")}
        ) {
            Text("Button to Home Screen")
        }

        Button(
            onClick = { navController.navigate("test_screen")}
        ) {
            Text("Button to Test Screen")
        }
        Button(
            onClick = { navController.navigate("interface")}
        ) {
            Text("Button to Starbucks Screen")
        }
        Button(
            onClick = { navController.navigate("android_components")}
        ) {
            Text("Button to Andriod Components")
        }

        Button(
            onClick = { navController.navigate("login_screen")}
        ) {
            Text("Button to Login Screen ")
        }
        Button(
            onClick = { navController.navigate("accounts_screen")}
        ) {
            Text("Button to Accounts Screen ")
        }

    }

}

