package com.example.aprendiz

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aprendiz.screens.HomeScreen
import com.example.aprendiz.screens.CalendarioScreen
import com.example.aprendiz.screens.ConfiguracionScreen
import com.example.aprendiz.screens.DetalleNotificacionScreen
import com.example.aprendiz.screens.NotificacionScreen
import com.example.aprendiz.screens.PerfilScreen
import com.example.aprendiz.screens.RegistroVisitaScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("calendario") { CalendarioScreen(navController = navController) }
        composable("notificaciones") { NotificacionScreen(navController) }
        composable("detalleNotificacion/{notificacionId}") { navBackStackEntry ->
            DetalleNotificacionScreen(navController = navController, navBackStackEntry = navBackStackEntry) }
        composable("registro_visita") {
            RegistroVisitaScreen(navController = navController) }
        composable("perfil") { PerfilScreen(navController = navController) }
        composable("configuracion") { ConfiguracionScreen(navController = navController) }
    }
}