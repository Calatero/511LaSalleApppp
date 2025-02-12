package com.example.a511lasalleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a511lasalleappp.ui.theme._511LaSalleApppTheme

@Composable
fun Widget(icon: ImageVector, title: String, isClickable: Boolean = false, onClick: () -> Unit = {}){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(90.dp)
            .background(MaterialTheme.colorScheme.background)
            .let{
                if (isClickable) it.clickable(onClick = onClick) else it
            },
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                imageVector = icon,
                contentDescription = null, tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp))
            Text(text = title, color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodySmall)
        }
    }
}