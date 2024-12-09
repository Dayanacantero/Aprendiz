package com.example.aprendiz.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aprendiz.R


@Composable
fun HomeScreen(navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .verticalScroll(rememberScrollState()) // Habilita el desplazamiento
    ) {
        // Primer LinearLayout en horizontal
        Row(
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
            Box(modifier = Modifier
                .fillMaxWidth()  // Ocupa todo el ancho de la pantalla
                .wrapContentSize(Alignment.TopEnd),
            ) {
                Text(
                    text = "Dayana",
                    modifier = Modifier
                        .background(Color(0xFFFFFFFF))
                        .padding(10.dp)
                        .clickable { expanded = true },
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
            // Textos centrados
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
                    Text(
                        text = "Inicio",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clickable { navController.navigate("home") }
                            .padding(8.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Calendario",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .clickable { navController.navigate("calendario") }
                            .padding(8.dp)
                    )
                }
            }
        }
        InstructorContainer()

        // Bitácora
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(vertical = 8.dp)
                .background(Color(0xFFF7F7F7)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp), // Padding interno
                horizontalAlignment = Alignment.CenterHorizontally, // Alinear horizontalmente
                verticalArrangement = Arrangement.Center // Alinear verticalmente
            ) {
                Text(
                    text = "Bitácoras",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp) // Margen inferior
                )

                // Contenedor para el gráfico circular
                BitacoraCircularGraph()
            }
        }
        TimelineContainer()
    }
}


// Gráfico Circular que cambia de color y se llena al hacer clic
@Composable
fun BitacoraCircularGraph() {
    var progress by remember { mutableStateOf(0f) }  // Control de progreso
    var colorIndex by remember { mutableStateOf(0) }  // Índice para los colores (0 = Rojo, 1 = Amarillo, 2 = Verde)
    var clickCount by remember { mutableStateOf(0) }  // Contador de clics

    // Colores que se alternarán
    val colors = listOf(Color.Red, Color.Yellow, Color.Green)

    // Contenedor donde se muestra el gráfico
    Surface(
        modifier = Modifier
            .size(200.dp) // Aseguramos que el tamaño sea cuadrado para evitar el óvalo
            .padding(vertical = 8.dp)
            .background(Color(0xFFF7F7F7)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.clickable {
                // Limitar los clics a 3
                if (clickCount < 3) {
                    // Incrementar el progreso y cambiar el color
                    progress = if (progress < 1f) progress + 0.33f else 0f  // Reinicia el progreso después de 3 clics

                    // Cambiar el color ciclando entre los 3 colores
                    colorIndex = (colorIndex + 1) % colors.size
                    clickCount += 1  // Aumentar el contador de clics
                }
            }
        ) {
            // Dibujar el gráfico circular
            CircularProgressBar(progress = progress, color = colors[colorIndex])
        }
    }
}

@Composable
fun CircularProgressBar(progress: Float, color: Color) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val radius = size.minDimension / 0  // Radio del círculo

        // Fondo gris claro del círculo (el círculo no está completamente relleno, solo se dibuja el contorno)
        drawCircle(
            color = Color.LightGray,
            radius = radius,
            style = Stroke(width = 30f)
        )

        // Círculo de progreso (borde alrededor del círculo)
        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = 360 * progress,
            useCenter = false,
            style = Stroke(width = 30f),
            size = size.copy(
                width = size.width * 0.8f,
                height = size.height * 0.8f
            ),
            topLeft = center.copy(x = size.width * 0.1f, y = size.height * 0.1f)
        )
    }
}





@Composable
fun InstructorContainer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Card para el instructor asignado
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color(0xFFF7F7F7))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Instructor Asignado",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Column {
                    // Lista de detalles del instructor
                    DetailItem(label = "Nombre:", value = "Mariany Dorado")
                    DetailItem(label = "Correo:", value = "edusena10@gmail.com")
                    DetailItem(label = "Teléfono:", value = "322 546 78 67")
                }
            }
        }
    }
}

// Composable para mostrar los detalles del instructor
@Composable
fun DetailItem(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = "$label $value", fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp)) // Espaciado entre los items
        // Divider (simulando el hr)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White)
        )
    }
}

@Composable
fun TimelineContainer() {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .padding(vertical = 8.dp)
            .background(Color(0xFFF7F7F7)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Línea Temporal (Etapa de seguimiento)",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            // Contenedor del gráfico de línea temporal
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopStart
            ) {
                TimelineChart(events = listOf(
                    "Asignación - 2023-12-29",
                    "Inicio Etapa Productiva - 2024-01-01",
                    "Primera Visita - 2024-02-01",
                    "Segunda Visita - 2024-04-01",
                    "Tercera Visita - 2024-06-01",
                    "Finalización - 2024-08-01"
                ))
            }
        }
    }
}

// Composable que dibuja la línea temporal
@Composable
fun TimelineChart(events: List<String>) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        events.forEachIndexed { index, event ->
            TimelineEvent(eventText = event, isCompleted = index < 2) // Marcamos los primeros dos como completados
        }
    }
}

// Componente para representar cada evento de la línea temporal
@Composable
fun TimelineEvent(eventText: String, isCompleted: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        // Dibuja el círculo del evento
        Canvas(modifier = Modifier.size(20.dp)) {
            drawCircle(color = if (isCompleted) Color.Green else Color.Gray)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = eventText,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
    }
}