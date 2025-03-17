package com.example.workclass.ui.screens

import android.graphics.Picture
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass.R
import java.lang.reflect.Modifier

@Composable
fun ScanScreen(navController: NavHostController) {
    Column (
        modifier = androidx.compose.ui.Modifier
            .padding(10.dp)
            .fillMaxSize()
    ){
        Text("Scan your QR")

        Column() {
            pictureS()
        }

    }
}



@Preview(showBackground = true)
@Composable
fun pictureS (){
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(300.dp)
    ){
        Image(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.qr_code),
            contentDescription = "Imagen del codigo QR",
            contentScale = ContentScale.Crop

        )

    }
}