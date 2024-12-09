package com.example.aprendiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aprendiz.R

@Composable
fun PerfilScreen(navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .verticalScroll(rememberScrollState()) // Habilita el desplazamiento vertical
    ) {
        // Header con imágenes y menú desplegable
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

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.TopEnd)
            ) {
                Text(
                    text = "Dayana",
                    modifier = Modifier
                        .background(Color.White)
                        .shadow(4.dp, RoundedCornerShape(20.dp))
                        .padding(10.dp)
                        .clickable { expanded = true }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(onClick = {
                        expanded = false
                        navController.navigate("perfil")
                    }) {
                        Text("Ver perfil")
                    }

                    DropdownMenuItem(onClick = {
                        expanded = false
                        navController.navigate("configuracion")
                    }) {
                        Text("Configuración")
                    }

                    DropdownMenuItem(onClick = {
                        expanded = false
                    }) {
                        Text("Cerrar sesión")
                    }
                }
            }
        }

        // Barra inferior con opciones
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            color = Color(0xFF009E00)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Inicio",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable { navController.navigate("home") }
                )

                Text(
                    text = "Calendario",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable { navController.navigate("calendario") }
                )

                Image(
                    painter = painterResource(id = R.drawable.notificaciones),
                    contentDescription = "Notificaciones",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable { navController.navigate("notificaciones") },
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }

        // Información del perfil
        PerfilInfo(isEditing = isEditing)

        // Botón de actualizar
        Spacer(modifier = Modifier.height(8.dp)) // Reducido el espacio antes del botón
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { isEditing = !isEditing },
                modifier = Modifier.padding(8.dp), // Reducido el padding
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF009E00))
            ) {
                Text(text = if (isEditing) "Guardar" else "Actualizar", color = Color.White)
            }
        }
    }
}

@Composable
fun PerfilInfo(isEditing: Boolean) {
    var nombres by remember { mutableStateOf("Dayana") }
    var apellidos by remember { mutableStateOf("Cantero") }
    var correo by remember { mutableStateOf("dayana@gmail.com") }
    var cuenta by remember { mutableStateOf("Activa") }
    var departamento by remember { mutableStateOf("Cauca") }
    var municipio by remember { mutableStateOf("Popayan") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFE0E0E0), shape = MaterialTheme.shapes.medium)
            .border(
                3.dp,
                Brush.verticalGradient(listOf(Color.Gray.copy(alpha = 0.2f), Color.Transparent)),
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "USUARIO",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Datos básicos", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(10.dp))
        InfoItem(label = "Nombres:", value = nombres, isEditing = isEditing, onValueChange = { nombres = it })
        InfoItem(label = "Apellidos:", value = apellidos, isEditing = isEditing, onValueChange = { apellidos = it })
        InfoItem(label = "Correo electrónico:", value = correo, isEditing = isEditing, onValueChange = { correo = it })
        InfoItem(label = "Cuenta Soy SENA:", value = cuenta, isEditing = isEditing, onValueChange = { cuenta = it })
        InfoItem(label = "Departamento:", value = departamento, isEditing = isEditing, onValueChange = { departamento = it })
        InfoItem(label = "Municipio:", value = municipio, isEditing = isEditing, onValueChange = { municipio = it })
    }
}

@Composable
fun InfoItem(label: String, value: String, isEditing: Boolean, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, fontWeight = FontWeight.Bold)
        if (isEditing) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        } else {
            Text(
                text = value,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }
    }
}