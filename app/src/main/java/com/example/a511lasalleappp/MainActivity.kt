package com.example.a511lasalleappp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a511lasalleapp.ui.screens.DetalleMateriaScreen
import com.example.a511lasalleappp.models.BottomNavigationItem
import com.example.a511lasalleappp.ui.screens.CalendarScreen
import com.example.a511lasalleappp.ui.screens.CambiarContrasenaScreen
import com.example.a511lasalleappp.ui.screens.CambiarTemaAppScreen
import com.example.a511lasalleappp.ui.screens.GradesScreen
import com.example.a511lasalleappp.ui.screens.HomeScreen
import com.example.a511lasalleappp.ui.screens.NewsDetailScreen
import com.example.a511lasalleappp.ui.screens.PagosScreen
import com.example.a511lasalleappp.ui.screens.SettingsScreen
import com.example.a511lasalleappp.ui.theme._511LaSalleApppTheme
import com.example.a511lasalleappp.utils.Screens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var selectedItem by rememberSaveable {
                mutableIntStateOf(0)
            }
            _511LaSalleApppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedNavigationBar(
                            selectedIndex = selectedItem,
                            modifier = Modifier.height(100.dp),
                            barColor = MaterialTheme.colorScheme.primary,
                            cornerRadius = shapeCornerRadius(cornerRadius = 34.dp)
                        ) {
                            BottomNavigationItem.items.forEachIndexed { index, bottomNavigationItem ->
                                Column (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clickable {
                                            selectedItem = index
                                            navController.navigate(bottomNavigationItem.route)
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ){
                                    Icon(
                                        imageVector = bottomNavigationItem.icon,
                                        contentDescription = bottomNavigationItem.title,
                                        tint = if(selectedItem == index) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Text(
                                        bottomNavigationItem.title,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = if(selectedItem == index) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                                    )
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = Screens.Home.route){
                        composable(route = Screens.Home.route) {
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Grades.route) {
                            GradesScreen(innerPadding = innerPadding, navController)
                        }
                        composable(route = Screens.Calendar.route) {
                            CalendarScreen(innerPadding)
                        }
                        composable(route = Screens.Settings.route) {
                            SettingsScreen(innerPadding = innerPadding, navController)
                        }
                        composable(
                            route = Screens.NewsDetail.route+"/{newsId}",
                            arguments = listOf(
                                navArgument("newsId"){
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val newsId = it.arguments?.getInt("newsId") ?: 0
                            NewsDetailScreen(innerPadding = innerPadding, newsId = newsId)
                        }
                        composable(route = Screens.Pagos.route){
                            PagosScreen(paddingValues = innerPadding, navController)
                        }
                        composable(
                            route = Screens.DetalleMateria.route+"/{materiaId}",
                            arguments = listOf(
                                navArgument("materiaId"){
                                    type = NavType.IntType
                                }
                            )
                        ){
                            val materiaId = it.arguments?.getInt("materiaId") ?: 0
                            DetalleMateriaScreen(innerPadding, materiaId)
                        }
                        composable(route = Screens.CambiarTemaAppScreen.route){
                            CambiarTemaAppScreen(paddingValues = innerPadding)
                        }
                        composable(route = Screens.CambiarContrasena.route){
                            CambiarContrasenaScreen(paddingValues = innerPadding)
                        }
                    }
                }
            }
        }
    }
}