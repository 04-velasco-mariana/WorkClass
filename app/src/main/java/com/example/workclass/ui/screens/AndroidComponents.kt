package com.example.workclass.ui.screens

import android.app.AlertDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.util.logging.Filter


@Composable
fun AndroidComponents (navController: NavHostController){
   // Buttons()
    //FloatingButtons()
    //Progress()
   // Chips()
    //Sliders()
   // Switches()
    //Badges()
    //SnackBars()
    AlertDialogs()
}


@Preview(showBackground = true)
@Composable
    fun Buttons(){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Button(onClick = {}) {
                Text("Filled")
            }
            FilledTonalButton(onClick = {}) {
                Text("Tonal")
            }
            OutlinedButton(onClick = {}) {
                Text("Outlined")
            }
            ElevatedButton(onClick = {}) {
                Text("Elevated")
            }
            TextButton(onClick = {}) {
                Text("Text")
            }
        }
}

@Preview(showBackground = true)
@Composable
fun FloatingButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) { //este boton es mas pequeño que el primero
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
        }
        LargeFloatingActionButton(onClick = {}) { //este es mas grande
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
        }
        ExtendedFloatingActionButton(onClick = {}) { //rectangulo mas grande
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
            Text("Button")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}
@Preview(showBackground = true) //sirve para presentar informacion
@Composable
fun Chips() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label= { Text("Assist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize))
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected =selected ,
            onClick = {selected= !selected },
            label = {Text("Filter Chip")},
            leadingIcon =if (selected){
            {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
            } else {
                null
            }
        )
        InputChipExample("Dismiss",{})
    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss:() -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        label= { Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar= {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon ={
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}
@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = {SliderPosition= it },
            steps = 10,
            valueRange = 0f..100f
        )
        Text (
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )

        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = { checked2 = it },
            thumbContent = if (checked2){
                {
                    Icon (
                        Icons.Filled.Check,
                        contentDescription = "Icon Check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3= it}
        )
    }
}


@Composable
fun Badges() { //iconos de mensajes sin leer o notificaciones
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart icon"
            )
        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }
}

@Composable
fun SnackBars() { //Barra de notificacion cuando hacemos una accion
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val snackState = remember { SnackbarHostState() } //guarda el estado de si se esta mostrando o no
        val snackScope = rememberCoroutineScope() //controla cuanto tiempo se queda en pantalla

        SnackbarHost(hostState = snackState)

        fun launchSnackBar (){
            snackScope.launch { snackState.showSnackbar("The message has been sent") }
        }

        Button(::launchSnackBar) {
            Text("Send message")
        }
    }
}

@Composable
fun AlertDialogs() { //Lanza un mensaje y al mismo tiempo nos pide una confirmacion y no desaparece  hasta elegir la accion
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog){
           AlertDialog(
               icon= { Icon (Icons.Filled.Warning, contentDescription = "Warning Icon")},
               title = {Text ("Confirm Deletion")},
                   text = {Text("Are you sure you want to delete this file?")},
                   onDismissRequest ={},
                   confirmButton = {
                       TextButton(
                           onClick = {
                               selectedOption = "Confirmed"
                               showAlertDialog = false
                           }
                       ) {
                           Text("Yes")
                       }
                   },
                           dismissButton = {
                       TextButton(
                           onClick = {
                               selectedOption = "Canceled"
                               showAlertDialog = false
                           }
                       ) {
                           Text("No")
                       }
                   }
           )
        }

        Button (onClick = { showAlertDialog=true}) {
            Text("Delete file")
        }
        Text (selectedOption)

    }
}