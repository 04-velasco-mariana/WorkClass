package com.example.workclass.ui.screens


import android.content.ClipDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
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
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.workclass.R



@Composable
fun StarbucksInterface(navController: NavController) { //funcion principal de la UI
    Box (modifier = Modifier
            .fillMaxSize()
        .background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) //permite hacer el scroll
                .padding(bottom = 56.dp)
        ) {
            //mando a llamar cada una de las funciones
            TopBar()
            RewardSection()
            PromotionsList()
            FloatingScanButton(navController)
        }
        Box (modifier = Modifier.fillMaxWidth()
            .align(Alignment.BottomCenter))
        {
           BottomNavBar() //barra de navegacion
        }

    }
    }


@Composable
fun TopBar() { //barra de navegacion principal
    Column(
        modifier = Modifier
            .fillMaxWidth() //ocupe la pantalla completa
    ) {
        Text("Good morning,", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text("Mariana Lizeth", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(Icons.Default.AccountBox, contentDescription = "Profile Icon", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(5.dp)) //crea un espacio horizontal
                Text("Profile", fontSize = 16.sp, color = Color.Black)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(Icons.Default.Email, contentDescription = "Email Icon", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Icon(Icons.Default.Settings, contentDescription = "Settings Icon", modifier = Modifier.size(30.dp))


            }
        }
    }
}
@Composable
fun RewardSection() { //Seccion de la parte de Recompensas
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("34 Star", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)

            Spacer(
                modifier = Modifier
                    .size(5.dp))
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star icon",
                tint = colorResource(id = R.color.sacramento),
                modifier = Modifier
                    .size(30.dp)
            ) }

        Spacer(modifier = Modifier.height(8.dp)) //este es el elemento que agregue no visto en clase
        LinearProgressIndicator( //Este es un elemento que agregué para poder visualizar la linea de progresion de las estrellas de recompensa
            progress = 0.2f, //representa el porcentaje de la linea
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = colorResource(id = R.color.sacramento), //para cambiar el color de la linea agregue este color al archivo xml
        )
        OutlinedButton(
            onClick = { /* no tiene acciones el boton */ },
            shape = RoundedCornerShape(20.dp)
        ){
            Text("Rewards details",
                color = Color.Black)
        }

        Spacer(modifier = Modifier
            .height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End //alinear el boton
        ) {
            OutlinedButton(
                onClick = { /* no tiene acciones el boton */ },
                shape = RoundedCornerShape(20.dp) //modificar el contorno del boton
            ) { //use este tipo de boton que solo tiene el margen mas no esta relleno, este fue uno de los elementos no vistos en clase
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Rewards",
                        color = Color.Black)
                    Spacer(
                        modifier = Modifier
                            .width(5.dp))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Icon star",
                        tint = colorResource(id = R.color.sacramento), //mando a llamar un color que cree en xml colors
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun PromotionsList() { //funcion con las imagenes y el texto de promocion
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        PromotionCard( // esta funcion se manda a llamar en la lista de promociones y no en StarbucksInterface
            "Un nuevo color para tu semana esta listo para sorprenderte",
            "Estrenalo con una bebida de cortesia ",
            R.drawable.s_image1
        )
        PromotionCard(
            "Sigamos celebrando el amor y la amistad ",
            "Activala por $250 o mas y registrala en tu App",
            R.drawable.s_image2
        )


    }
}

@Composable
fun PromotionCard(title : String , description: String, imageRes: Int){ //se declararon parametros en la funcion para poder ser utilizados en PromotionsList
Card (
    modifier = Modifier
        .padding(10.dp)
        .background(Color.White)
        .fillMaxWidth(),

    shape = RoundedCornerShape(10.dp)
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = imageRes), //utilize un id en el recurso de la imagen para poder mandarla a llamar en la funcion de Promotional Card y ser utilizada en List
            contentDescription = "Promotional Images",
            modifier = Modifier
                .fillMaxWidth()

        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(description, fontSize = 14.sp, color = Color.Gray)


        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Button(
            onClick = {/* no tiene acciones el boton*/},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.sacramento))
        ) {
            Text("Details", color = Color.White)
        }
    }
}
}

@Composable
fun FloatingScanButton(navController: NavController){ //boton de Scan
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 90.dp, end = 16.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        Button(
            onClick = {navController.navigate("scan_screen")},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id=R.color.sacramento)),
            shape=  RoundedCornerShape(50),
            modifier = Modifier
                .padding(bottom = 16.dp, end = 16.dp)

        ) {
                Text("Scan", color = Color.White, fontSize = 16.sp)
            }

        }

    }


@Composable
fun BottomNavBar(){ //barra de navegacion 
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)

    )
    Image(
        painter = painterResource(R.drawable.buttons_starbucks), //opte por poner un ss de la imagen debido a la dificultad que tuve para poner cada icono porque no estaban en la libreria
        contentDescription = "Bottons",
        modifier = Modifier
    )
}
















