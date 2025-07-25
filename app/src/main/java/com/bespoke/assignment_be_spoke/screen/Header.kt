package com.bespoke.assignment_be_spoke.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import com.bespoke.assignment_be_spoke.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape

@Composable
fun Header() {
    Surface(
        shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp),
        color = MaterialTheme.colorScheme.primary, // or Color.White if you want white background
        shadowElevation = 4.dp // optional: adds shadow below
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Row for Home icon + LoyalLoop text together
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.size(8.dp)) // optional spacing
                Text(
                    text = "LoyalLoop",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            // Profile icon (circular image placeholder)
            Image(
                painter = painterResource(id = R.drawable.ic_profile), // replace with your profile image resource
                contentDescription = "Profile",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
            )
        }
    }
}
