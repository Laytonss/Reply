package com.thoughtworks.training.reply.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class BottomNavigationItem {
    EMAILS, ARTICLE, CHAT, GROUP
}

@Composable
fun MyApp() {
    val (selectedItem, setSelectedItem) = remember { mutableStateOf(BottomNavigationItem.EMAILS) }
    Scaffold(
        bottomBar = {
            AppBottomBar(selectedItem) { newItem -> setSelectedItem(newItem) }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                modifier = Modifier.padding(16.dp).size(80.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit"
                )
            }
        }
    ) { innerPadding ->
        when (selectedItem) {
            BottomNavigationItem.EMAILS -> {
                EmailHome(modifier = Modifier.padding(innerPadding))
            }

            BottomNavigationItem.ARTICLE -> {
                ScreenUnderConstruction()
            }

            BottomNavigationItem.CHAT -> {
                ScreenUnderConstruction()
            }

            BottomNavigationItem.GROUP -> {
                ScreenUnderConstruction()
            }
        }
    }
}

@Composable
fun AppBottomBar(selectedItem: BottomNavigationItem, onItemSelected: (BottomNavigationItem) -> Unit) {
    BottomAppBar(
        actions = {
            IconButton(onClick = { onItemSelected(BottomNavigationItem.EMAILS) }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { onItemSelected(BottomNavigationItem.ARTICLE) }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Edit, contentDescription = "Localized description")
            }
            IconButton(onClick = { onItemSelected(BottomNavigationItem.CHAT) }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Mic, contentDescription = "Localized description")
            }
            IconButton(onClick = { onItemSelected(BottomNavigationItem.GROUP) }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Image, contentDescription = "Localized description")
            }
        },
    )
}
