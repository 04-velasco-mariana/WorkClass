
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
fun Interface (navController: NavHostController){
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()

    ) {

        Text ("Good morning, Mariana Lizeth")
    }

    }
