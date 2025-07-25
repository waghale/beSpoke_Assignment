package com.bespoke.assignment_be_spoke.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    var selectedScreen by remember { mutableStateOf("home") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedScreen = selectedScreen,
                onItemClick = { selectedScreen = it }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedScreen) {
                "home" -> HomeScreen()
                "menu" -> MenuScreen()
                "notifications" -> NotificationScreen()
                "profile" -> ProfileScreen()
            }
        }
    }
}





@Composable
fun BottomNavigationBar(selectedScreen: String, onItemClick: (String) -> Unit) {
    Surface(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        shadowElevation = 8.dp // optional: adds elevation shadow
    ) {
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = selectedScreen == "home",
                onClick = { onItemClick("home") }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Menu, contentDescription = "Menu") },
                label = { Text("Menu") },
                selected = selectedScreen == "menu",
                onClick = { onItemClick("menu") }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Notifications, contentDescription = "Notifications") },
                label = { Text("Notifications") },
                selected = selectedScreen == "notifications",
                onClick = { onItemClick("notifications") }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                label = { Text("Profile") },
                selected = selectedScreen == "profile",
                onClick = { onItemClick("profile") }
            )
        }
    }
}


