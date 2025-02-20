package com.example.workclass.ui.screens


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.workclass.R



@Composable
fun StarbucksInterface(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopBar()
        //RewardSection()
        //PromotionsList()
        //Spacer(modifier = Modifier.weight(1f))
        //BottomNavBar()
    }
}

@Composable
fun TopBar() { //barra de navegacion principal
    Column(
        modifier = Modifier.fillMaxWidth() //ocupe la pantalla completa
    ) {
        Text("Good morning,", fontSize = 18.sp, color = Color.Black)
        Text("Mariana Lizeth", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(Icons.Default.AccountBox, contentDescription = "Profile Icon", modifier = Modifier.size(30.dp)) //icono de Profile Icon
                Spacer(modifier = Modifier.width(10.dp))
                Icon(Icons.Default.Email, contentDescription = "Messages Icon", modifier = Modifier.size(30.dp)) //Icono de Email y mensajeria
            }
            Icon(Icons.Default.Settings, contentDescription = "Settings Icon", modifier = Modifier.size(30.dp)) // Icono de configuracion
        }
    }
}

