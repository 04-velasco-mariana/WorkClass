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
            .verticalScroll(rememberScrollState()) //permite hacer el scroll
    ) {
        TopBar()
        RewardSection()
        PromotionsList()
        //Spacer(modifier = Modifier.weight(1f))
        //BottomNavBar()
    }
}



@Composable
fun TopBar() { //barra de navegacion principal
    Column(
        modifier = Modifier
            .fillMaxWidth() //ocupe la pantalla completa
    ) {
        Text("Good morning,", fontSize = 18.sp, color = Color.Black)
        Text("Mariana Lizeth", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    Icons.Default.AccountBox,
                    contentDescription = "Profile Icon",
                    modifier = Modifier.
                    size(30.dp)) //icono de Profile Icon
                Spacer(
                    modifier = Modifier
                        .width(10.dp)) //Spacer se agrego para generar un espacio horizontal entre los iconos
                Icon(
                    Icons.Default.Email,
                    contentDescription = "Messages Icon",
                    modifier = Modifier.
                    size(30.dp)) //Icono de Email y mensajeria
            }
            Icon(
                Icons.Default.Settings,
                contentDescription = "Settings Icon",
                modifier = Modifier.
                size(30.dp)) // Icono de configuracion
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
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star Icon",
                tint = colorResource(id = R.color.sacramento),
                modifier = Modifier.size(30.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(5.dp)
            )
            Text("34 Star", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator( //Este es un elemento que agregué para poder visualizar la linea de progresion de las estrellas de recompensa
            progress = 0.2f, //representa el porcentaje de la linea
            modifier = Modifier.fillMaxWidth().height(8.dp)
        )

                Spacer(
                    modifier = Modifier
                        .width(5.dp))

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            OutlinedButton(
                onClick = { /* no tiene acciones el boton */ },
                shape = RoundedCornerShape(20.dp)
            ) { //use este tipo de boton que solo tiene el margen mas no esta relleno
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
fun PromotionsList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
        .fillMaxWidth(),
    shape = RoundedCornerShape(10.dp)

) {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
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

        OutlinedButton(
            onClick = { /* no tiene acciones el boton */ },
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Details ",
                color = Color.Black)

        }
    }
}
}




