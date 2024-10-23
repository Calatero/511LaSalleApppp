package com.example.a511lasalleappp.utils

sealed class Screens(val route : String) {
    data object Home : Screens("home")
    data object Grades : Screens("grades")
    data object Calendar : Screens("calendar")
    data object Settings : Screens("settings")
    data object NewsDetail : Screens("news-detail")
    data object Pagos : Screens("pagos")
    data object DetalleMateria : Screens("detalle-materia")
    data object CambiarTemaAppScreen : Screens("cambiar-tema-app")
    data object CambiarContrasena : Screens("cambiar-contrasena")
}