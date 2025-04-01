package com.example.workclass.ui.components

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TopBarComponent(title:String){
    TopAppBar(
        title ={ Text (title)},
        actions = {
            IconButton(onClick = {}) {
                Icon (imageVector= Icons.Filled.Settings,contentDescription = "Icon")
            }
        }
    )
}