package com.example.aprendiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aprendiz.R

@Composable
fun NotificacionScreen (navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 30.dp)
    ) {
        // Primer LinearLayout en horizontal
        Row  (
            modifier = Modifier.padding(0.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.sena),
                contentDescription = "Logo SENA",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Etapa Productiva",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    "Etapa\nProductiva",
                    fontSize = 13.sp,
                    color = Color(0xFF009E00),
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .offset(x = (-5).dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    "Centro de Comercio y Servicios",
                    fontSize = 14.sp,
                    color = Color(0xFF009E00),
                    modifier = Modifier.offset(x = (-30).dp)
                )
            }

            // Texto "Dayana" con el menú desplegable
            Box( modifier = Modifier
                .fillMaxWidth()  // Ocupa todo el ancho de la pantalla

                .wrapContentSize(Alignment.TopEnd),
                contentAlignment = Alignment.CenterStart

            ) {

                Text(
                    text = "Dayana",
                    modifier = Modifier
                        .background(Color(0xFFFFFFFF))
                        .shadow(4.dp, RoundedCornerShape(20.dp))
                        .padding(10 .dp)
                        .clickable { expanded = true },



                    // Hacemos que el texto sea clickable para mostrar el menú
                )

// Menú desplegable
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },


                    ) {
                    // Información del usuario
                    Row(modifier = Modifier.padding(bottom = 12.dp)) {
                        Column {
                            Text(
                                text = "Dayana Cantero",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Aprendiz",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                    DropdownMenuItem(onClick = {
                        expanded = false
                        navController.navigate("perfil") // Navegar a la pantalla de perfil

                    }) {
                        Text("Ver perfil")
                    }

                    DropdownMenuItem(onClick = {
                        expanded = false
                        // Navegar a la pantalla de configuración u otro lugar
                        navController.navigate("configuracion")
                    }) {
                        Text("Configuración")
                    }

                    DropdownMenuItem(onClick = {
                        expanded = false
                        // Implementar la acción de cerrar sesión
                    }) {
                        Text("Cerrar sesión")
                    }
                }

            }

        }
        // Segundo LinearLayout que aparecerá debajo del primero
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xFF009E00)),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom, // Mueve el contenido al final
                horizontalAlignment = Alignment.End // Alinea el contenido a la derecha
            ) {
                // Contenedor para el ImageButton y TextView

                Image(
                    painter = painterResource(id = R.drawable.notificaciones),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)

                        .clickable {
                            navController.navigate("notificaciones") // Navega a la pantalla de notificaciones
                        },
                    colorFilter = ColorFilter.tint(Color.White)


                )
            }
            // Botones centrados
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center, // Centra verticalmente
                horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center // Centra horizontalmente dentro de la fila
                ) {
                    Button(
                        onClick = { navController.navigate("home") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        )
                    ) {
                        Text(text = "Inicio")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { navController.navigate("calendario") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        )
                    ) {
                        Text(text = "Calendario")
                    }
                }
            }
        }
            // NOTIFICACIONES
            // Lista de notificaciones de ejemplo
            val notificaciones = listOf(
                "Notificación 1",
                "Notificación 2",
                "Notificación 3",
                "Notificación 4"
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Notificaciones",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                    )

                    // Listado de notificaciones
                    LazyColumn {
                        items(notificaciones.size) { index ->
                            NotificacionItem(
                                title = notificaciones[index],
                                onClick = {
                                    navController.navigate("detalleNotificacion/${index}")
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }


    }
}
@Composable
fun NotificacionItem(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp)
        .background(Color(0xFF009E00)),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),
            color = Color.Black
        )
    }
}