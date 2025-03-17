package com.example.workclass.ui.screens

import android.app.AlertDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclass.R
import com.example.workclass.data.model.MenuModel
import com.example.workclass.data.model.PostCardModel
import com.example.workclass.ui.components.PostCardCompactComponent
import com.example.workclass.ui.components.PostCardComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.annotations.ApiStatus
import java.util.logging.Filter
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.swiperefresh.SwipeRefresh
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


@Composable
fun AndroidComponents (navController: NavHostController){

    val menuOptions= arrayOf(
        MenuModel(1,"Buttons", "buttons", Icons.Filled.Add), //arreglo de un elemento basado en un modelo
        MenuModel(2,"Floating Buttons", "second", Icons.Filled.Add),
        MenuModel(3,"Progress", "third", Icons.Filled.Add),
        MenuModel(4,"Chips", "fourth", Icons.Filled.Add),
        MenuModel(5,"Sliders", "five", Icons.Filled.Add),
        MenuModel(6,"Switches", "sixth", Icons.Filled.Add),
        MenuModel(7,"Badges", "seven", Icons.Filled.Add),
        MenuModel(8,"Snack Bars", "eight", Icons.Filled.Add),
        MenuModel(9,"Alert Dialog", "nine", Icons.Filled.Add),
        MenuModel(10,"Bars", "ten", Icons.Filled.Add),
        MenuModel(10,"Input Fields", "eleven", Icons.Filled.Add),
        MenuModel(10,"Date Pickers", "twelve", Icons.Filled.Add),
        MenuModel(10,"Bottom Sheets", "thirteen", Icons.Filled.Add),
        MenuModel(10,"Segmented Buttoms", "fourteen", Icons.Filled.Add)

    )

    var option by rememberSaveable { mutableStateOf("buttons") } //guardar la opcion que elige
    var drawerState = rememberDrawerState(initialValue =DrawerValue.Closed )
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer (
        drawerState = drawerState, //cual es el estado del menu abierto o cerrado
        drawerContent = {
            ModalDrawerSheet {
                Text("Menú", modifier = Modifier.padding(16.dp))
                HorizontalDivider() //linea horizontal que divide
                LazyColumn {
                    items(menuOptions) { item ->
                    NavigationDrawerItem(
                        icon = {
                            Icon(item.icon, contentDescription = "Icon")
                        },
                        label = { Text(item.title) },
                        selected = false,
                        onClick = {
                            option = item.option
                            scope.launch { //accede a la propiedad del estado de drawer y lo cierra
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                }
            }
        }
}
) {

        Column{
            when(option){
                "first" -> {
                    Buttons()
                }
                "second" -> {
                    FloatingButtons()
                }
                "third" -> {
                    Progress()
                }
                "fourth" ->{
                    Chips()
                }
                "five" -> {
                    Sliders()
                }
                "sixth" -> {
                    Switches()
                }
                "seven" -> {
                    Badges()
                }
                "eight" -> {
                    SnackBars()
                }
                "nine" -> {
                    AlertDialogs()
                }
                "ten" -> {
                    Bars()
                }
                "eleven" -> {
                    InputFields()

                }
                "twelve" -> {
                    DatePickers(onDateSelected = { selectedDate ->
                        // Manejar la fecha seleccionada aquí
                        println("Fecha seleccionada: $selectedDate")
                    },
                        onDismiss = {
                            // Manejar el cierre del diálogo aquí
                            println("DatePicker cerrado")
                        })

                }
                "thirteen" -> {
                    BottomSheets()

                }
                "fourteen" -> {
                    SegmentedButtons()

                }


            }
        }

    }
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
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Bars() {
    // Estado de la recarga
    var isRefreshing by remember { mutableStateOf(false) }

    // Estado del PullRefresh
    val refreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            // Simular una carga de datos
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000) // Simula una carga de datos
                isRefreshing = false
            }
        }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(refreshState)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Barra superior
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.White,
                    containerColor = Color.Black
                ),
                title = { Text("Screen title") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
                    }
                }
            )

            // Contenido dentro del Pull to Refresh
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Adaptive()
            }

            // Barra inferior
            BottomAppBar(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            ) {
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Warning, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = "")
                }
            }
        }

        // Indicador de recarga
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = refreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}




@Composable
fun Adaptive (){
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    //Compact width < 600 dp Phone Portrait (parado)
    //Medium width >= 600 dp < 840 dp Tablet Portrait (parada)
    //Expanded width >= 840 dp Tablet Landscape (acostada)

    //Compact height < 480 dp Phone Landscape (acostado)
    //Medium height >= 480 dp < 900 dp Tablet Landscape o Phone Portrait (acostado)
    //Expanded height >= 900 dp Tablet Portrait (parada)

    val arrayPost= arrayOf(
        PostCardModel(1,"Title 1", "Text 1", R.drawable.images),
        PostCardModel(2,"Title 2", "Text 2", R.drawable.images),
        PostCardModel(3,"Title 3", "Text 3", R.drawable.images),
        PostCardModel(4,"Title 4", "Text 4", R.drawable.images),
        PostCardModel(5,"Title 5", "Text 5", R.drawable.images),
        PostCardModel(6,"Title 6", "Text 6", R.drawable.images),
        PostCardModel(7,"Title 7", "Text 7", R.drawable.images),
        PostCardModel(8,"Title 8", "Text 8", R.drawable.images),
        PostCardModel(9,"Title 9", "Text 9", R.drawable.images)

    )
    if (width == WindowWidthSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(arrayPost){ item ->
                PostCardCompactComponent(item.id,item.title,item.text,item.image) //parametros agregados en el PostComponent
                //ejemplo de pull to refresh

            }
        }
    } else if (height == WindowHeightSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(arrayPost){ item ->
                PostCardCompactComponent(item.id,item.title,item.text,item.image) //parametros agregados en el PostComponent
            }
        }
    }
}




// Función para obtener datos de ejemplo
fun samplePosts(): List<PostCardModel> = listOf(
    PostCardModel(1, "Title 1", "Text 1", R.drawable.images),
    PostCardModel(2, "Title 2", "Text 2", R.drawable.images),
    PostCardModel(3, "Title 3", "Text 3", R.drawable.images),
    PostCardModel(4, "Title 4", "Text 4", R.drawable.images),
    PostCardModel(5, "Title 5", "Text 5", R.drawable.images)
)


@Composable
fun InputFields (){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {text=it},
        label = {Text("Label")}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickers( //date picker modal
    onDateSelected: (Long?) -> Unit, //se ejecuta al seleccionar una fecha
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = { //muestra la hoja
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { contentPadding ->
        // Se utiliza contentPadding aquí para evitar error
        Box(modifier = Modifier.padding(contentPadding)) {
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }) {
                        Text("Hide bottom sheet")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedButtons(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Day", "Month", "Week")

    SingleChoiceSegmentedButtonRow { //este boton es unico (solo se muestra una opcion)
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}

