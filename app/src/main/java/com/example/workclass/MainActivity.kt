package com.example.workclass


import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclass.ui.screens.AccountsScreen
import com.example.workclass.ui.screens.AndroidComponents
import com.example.workclass.ui.screens.HomeScreen
import com.example.workclass.ui.screens.Interface
import com.example.workclass.ui.screens.LoginScreen
import com.example.workclass.ui.screens.MainMenuScreen
import com.example.workclass.ui.screens.StarbucksInterface
import com.example.workclass.ui.screens.TestScreen
import com.example.workclass.ui.theme.WorkClassTheme
import com.example.workclass.ui.screens.StarbucksInterface

import java.security.AccessController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {

            WorkClassTheme {
                ComposeMultiScreenApp()

            }

        }
    }

    @Preview(showBackground = true) //previsualizar la funcion
    @Composable
    fun TextComposabe(name: String = "Empty") {
        Text("Welcome")
        Text(name)
    }

    @Preview(showBackground = true)
    @Composable
    fun ModifierExample1() {
        Column(
            modifier = Modifier
                .padding(50.dp, 30.dp, 20.dp, 10.dp)
        ) {
            Text("Hello Wolrd")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ModifierExample2() {
        Column(
            modifier = Modifier
                .padding(24.dp, 10.dp)
                .fillMaxWidth() //ancho
                .clickable(onClick = { clickAction() })
        ) {
            Text("Hello Wolrd")
        }
    }

    fun clickAction() {
        println("Column Clicked")
    }

    @Preview(showBackground = true)
    @Composable
    fun ModifierExample3() {
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.Cyan)
                .border(width = 2.dp, color= Color.Black)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly

        ){
            TextComposabe("1")
            TextComposabe("2")
            TextComposabe("3")
            TextComposabe("4")
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample4() {
        Box(

            modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)
                .width(300.dp)
                .height(300.dp)
        ) {
            Text("1", Modifier.align(Alignment.TopStart))
            Text("2", Modifier.align(Alignment.TopCenter))
            Text("3", Modifier.align(Alignment.TopEnd))
            Text("4", Modifier.align(Alignment.CenterStart))
            Text("5", Modifier.align(Alignment.Center))
            Text("6", Modifier.align(Alignment.CenterEnd))
            Text("7", Modifier.align(Alignment.BottomStart))
            Text("8", Modifier.align(Alignment.BottomCenter))
            Text("9", Modifier.align(Alignment.BottomEnd))

        }
    }
    @Preview(showBackground = true)
    @Composable
    fun CustomText() {
        Column(){
            Text(
                stringResource(R.string.sample_text),
                color = colorResource(R.color.purple_200),
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
            )
            val gradientColors = listOf(Color.Cyan, Color.Red, colorResource(R.color.purple_200))
                Text(
                stringResource(R.string.sample_text),
                style = TextStyle(brush = Brush.linearGradient(colors=gradientColors ))

            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun picture (){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(300.dp)
        ){
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.images),
                contentDescription = "Imagen de un changuito",
                contentScale = ContentScale.Crop

            )

        }
    }

} //close class

@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    SetupNavGraph(navController= navController)

}
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination= "accounts_screen"){ //aqui estaba main_menuaccounts_screen
        composable("main_menu"){ MainMenuScreen(navController)}
        composable("home_screen"){ HomeScreen(navController)}
        composable("test_screen"){ TestScreen(navController) }

        composable("interface"){ StarbucksInterface(navController) }
        composable("android_components"){ AndroidComponents(navController) }
        composable("login_screen"){ LoginScreen(navController) }
        composable("accounts_screen"){ AccountsScreen(navController) }
    }

}



