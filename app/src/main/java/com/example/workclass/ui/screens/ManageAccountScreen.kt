package com.example.workclass.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.database.DataBaseProvider
import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.model.toAccountEntity
import com.example.workclass.data.viewmodel.AccountViewModel
import com.example.workclass.ui.components.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ManageAccountScreen(
    navController: NavController,
    prefilledAccount: AccountModel? = null,
    viewModel: AccountViewModel = viewModel()
) {
    val account = remember { mutableStateOf(prefilledAccount ?: AccountModel()) }
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val isEditing = prefilledAccount != null

    // Room DB
    val db = DataBaseProvider.getDatabase(context)
    val accountDao = db.accountDao()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(10.dp)
                .fillMaxSize()
        ) {
            TopBarComponent(
                if (isEditing) "Edit Account" else "Add Account",
                navController,
                "manage_account_screen"
            )

            OutlinedTextField(
                value = account.value.name,
                onValueChange = { account.value = account.value.copy(name = it) },
                label = { Text("Account Name") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = account.value.username,
                onValueChange = { account.value = account.value.copy(username = it) },
                label = { Text("Account Username") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = account.value.password,
                onValueChange = { account.value = account.value.copy(password = it) },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = account.value.description,
                onValueChange = { account.value = account.value.copy(description = it) },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )

            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                onClick = {
                    if (account.value.name.isBlank() || account.value.username.isBlank()
                        || account.value.password.isBlank() || account.value.description.isBlank()
                    ) {
                        Toast.makeText(context, "All fields must be filled", Toast.LENGTH_SHORT).show()
                        return@FilledTonalButton
                    }

                    if (isEditing) {
                        viewModel.updateAccount(account.value.id, account.value) { json ->
                            if (json != null) {
                                Log.d("debug", "API UPDATED ACCOUNT")

                                CoroutineScope(Dispatchers.IO).launch {
                                    try {
                                        accountDao.insert(account.value.toAccountEntity())
                                        Log.d("debug-db", "updated room account")
                                    } catch (e: Exception) {
                                        Log.d("debug-db", "failed to update room account: $e")
                                    }
                                }

                                CoroutineScope(Dispatchers.Main).launch {
                                    Toast.makeText(context, "Account Updated Successfully", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Log.d("debug", "failed to updated API")
                                CoroutineScope(Dispatchers.Main).launch {
                                    snackbarHostState.showSnackbar("Error updating account")
                                }
                            }
                        }
                    } else {
                        TryCreateAccount(account.value, context) {
                            CoroutineScope(Dispatchers.IO).launch {
                                try {
                                    accountDao.insert(account.value.toAccountEntity())
                                    Log.d("debug-db", "Successfully inserted room account")
                                } catch (e: Exception) {
                                    Log.d("debug-db", " Error to insert room account: $e")
                                }
                            }

                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(context, "Account Created Successfully", Toast.LENGTH_SHORT).show()

                            }
                        }
                    }
                }
            ) {
                Text(if (isEditing) "UPDATE ACCOUNT" else "SAVE ACCOUNT")
            }
        }
    }
}

fun TryCreateAccount(
    account: AccountModel,
    context: Context,
    onSuccess: () -> Unit
) {
    Log.d("debug", "Account Created Successfully: $account")
    onSuccess()
}
