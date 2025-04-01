package com.example.workclass.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage



@Composable
fun LoginScreen (navController: NavController){
    Column  (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        LoginForm()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginForm(){
    //val context = LocalContext.current
    Card(
        colors= CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .padding(40.dp, 0.dp)

    ){
       Column(
           modifier = Modifier
               .padding(20.dp)
       ){
           var user by remember { mutableStateOf("") }
           var password by remember { mutableStateOf("") }

           AsyncImage( //carga una imagen de una URL sin necesidad de estar en drawable
               model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPt4mvHEh4kyEkHx7bRVB1PXGPd_rvGZDmaA&s",//aqui va el logo .jpg o .png,
           contentDescription = "lOGO DE LEGO",
               contentScale= ContentScale.Fit
           )

           OutlinedTextField(
               modifier = Modifier
                   .fillMaxWidth(),
               value = user,
               maxLines = 1,
               onValueChange = { user = it},
               label= {Text("User:")},
               colors= OutlinedTextFieldDefaults.colors(
                   unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                   focusedBorderColor = MaterialTheme.colorScheme.secondary,
                   unfocusedContainerColor = Color.Transparent,
                   unfocusedTextColor = Color.White,
                   focusedTextColor = Color.White
               )
           )
           OutlinedTextField(
               modifier = Modifier
                   .fillMaxWidth(),
               value = password,
               maxLines = 1,
               onValueChange = { password = it},
               label= {Text("Password:")},
               colors= OutlinedTextFieldDefaults.colors(
                   unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                   focusedBorderColor = MaterialTheme.colorScheme.secondary,
                   unfocusedContainerColor = Color.Transparent,
                   unfocusedTextColor = Color.White,
                   focusedTextColor = Color.White
               )
           )
           FilledTonalButton(
               colors= ButtonDefaults.buttonColors(
                   containerColor = MaterialTheme.colorScheme.primary,
                   contentColor = MaterialTheme.colorScheme.secondary
               ),
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(0.dp, 10.dp),
               shape = CutCornerShape(4.dp),
               onClick = {/* TryLogin(user,password, context)*/}
           ) {
               Text("LOG IN")

           }
           OutlinedButton (
               colors= ButtonDefaults.buttonColors(
                   containerColor = Color.Transparent,
                   contentColor = MaterialTheme.colorScheme.primary
               ),
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(0.dp, 10.dp),
               shape = CutCornerShape(4.dp),
               onClick = {}
           ) {
               Text("Create Account")
           }
       }

    }
}

/*  fun TryLogin (users: String, password:String, context: Context){
if (user == "" password == ""){
Toast.makeTest(
context,
"User or Password cannot be empty",
Toast.LENGTH_SHORT
).show()
}

}
*/
