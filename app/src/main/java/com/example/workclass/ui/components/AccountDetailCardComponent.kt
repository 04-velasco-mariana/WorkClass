package com.example.workclass.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.workclass.R
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AccountDetailCardComponent(
    id: Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onSaveClick: () -> Unit,
    onDeleteClick: (Int) -> Unit,
    navController: NavController
) {
    val context = LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = imageURL,
            contentDescription = "Account Logo",
            contentScale = ContentScale.Fit,
            error = painterResource(R.drawable.images),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )

        //botones
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onSaveClick()
                Toast.makeText(context, "Saved as favorite", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Save as Favorite"
                )
            }

            IconButton(onClick = {
                val encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                val encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8.toString())
                val encodedPassword = URLEncoder.encode(password, StandardCharsets.UTF_8.toString())
                val encodedDescription = URLEncoder.encode(description, StandardCharsets.UTF_8.toString())

                navController.navigate(
                    "manage_account_screen/$id/$encodedName/$encodedUsername/$encodedPassword/$encodedDescription"
                )
            }) {
                Icon(Icons.Default.Edit, contentDescription = "Edit Account")
            }

            IconButton(onClick = {
                onDeleteClick(id)
            }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete Account"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // details
        InfoRow(title = "Account", value = name)
        InfoRow(title = "Username", value = username, showCopy = true, clipboardManager = clipboardManager)
        InfoRow(title = "Password", value = password, isPassword = true, clipboardManager = clipboardManager)
        InfoRow(title = "Description", value = description)
    }
}

@Composable
fun InfoRow(
    title: String,
    value: String,
    showCopy: Boolean = false,
    isPassword: Boolean = false,
    clipboardManager: ClipboardManager? = null
) {
    val showPassword = remember { mutableStateOf(false) }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$title:",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = if (isPassword && !showPassword.value) "••••••••" else value,
            modifier = Modifier.weight(2f)
        )
        //
        if (isPassword) {
            // Botón para copiar contraseña
            IconButton(onClick = {

                clipboardManager?.setText(AnnotatedString(value))
                Toast.makeText(context, "Password copied", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.ContentCopy,
                    contentDescription = "Copy Password"
                )
            }
        }

        // Copiar al portapapeles si aplica
        if (showCopy && clipboardManager != null) {
            IconButton(onClick = {
                clipboardManager.setText(AnnotatedString(value))
                Toast.makeText(context, "$title copied", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.ContentCopy,
                    contentDescription = "Copy $title"
                )
            }
        }
    }
}
