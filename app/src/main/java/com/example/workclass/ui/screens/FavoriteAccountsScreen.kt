package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.workclass.data.database.AppDataBase
import com.example.workclass.data.database.DataBaseProvider
import com.example.workclass.data.model.AccountEntity
import com.example.workclass.ui.components.FavoriteAccountCard
import com.example.workclass.ui.components.TopBarComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FavoriteAccountsScreen(navController: NavController){
    val db: AppDataBase = DataBaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()
    var accountsdb by remember { mutableStateOf<List<AccountEntity>>(emptyList()) }

    LaunchedEffect(Unit) {
        accountsdb = withContext (Dispatchers.IO){
            accountDao.getAll()
        }
    }
    Column (){
        TopBarComponent(
            "Favorite Accounts",
            navController,
            "favorite_accounts_screen"

        )
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize(),
            state = listState
        ) {
            items (accountsdb){
                accountdb->
                FavoriteAccountCard(
                    accountdb.id ?: 0,
                    accountdb.name ?: "",
                    accountdb.username ?: "",
                    accountdb.password ?: "",
                    accountdb.description ?: "",
                    accountdb.imageURL?: "",

                )
            }
        }
      //  FavoriteAccountCard()
    }
}