package com.example.aprendiz.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp) // Esto mueve el contenido más abajo
    ) {
        // Espacio extra al principio
        Spacer(modifier = Modifier.height(100.dp)) // Puedes ajustar este valor según sea necesario

        // Logo o Título de "Recuperar Contraseña"
        Text("Recuperar Contraseña", fontSize = 24.sp, color = (Color(0xFF009E00)), fontWeight = FontWeight.Bold)

        // Campo para ingresar el correo
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo Electrónico") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF009E00), // Color verde cuando está enfocado
                unfocusedBorderColor = Color.Gray, // Color gris cuando no está enfocado
                focusedLabelColor = Color(0xFF009E00), // Color verde para la etiqueta cuando está enfocado
                unfocusedLabelColor = Color.Gray // Color gris para la etiqueta cuando no está enfocado
            )
        )

        // Campo para la nueva contraseña
        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text("Nueva Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF009E00), // Color verde cuando está enfocado
                unfocusedBorderColor = Color.Gray, // Color gris cuando no está enfocado
                focusedLabelColor = Color(0xFF009E00), // Color verde para la etiqueta cuando está enfocado
                unfocusedLabelColor = Color.Gray // Color gris para la etiqueta cuando no está enfocado
            )
        )

        // Campo para confirmar la nueva contraseña
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF009E00), // Color verde cuando está enfocado
                unfocusedBorderColor = Color.Gray, // Color gris cuando no está enfocado
                focusedLabelColor = Color(0xFF009E00), // Color verde para la etiqueta cuando está enfocado
                unfocusedLabelColor = Color.Gray // Color gris para la etiqueta cuando no está enfocado
            )
        )

        // Botón para enviar la nueva contraseña
        Button(
            onClick = {
                if (newPassword == confirmPassword) {
                    // Aquí iría la lógica para actualizar la contraseña
                    navController.popBackStack() // Regresa a la pantalla de login
                } else {
                    // Mostrar un mensaje de error si las contraseñas no coinciden
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = (Color(0xFF009E00)))
        ) {
            Text("Cambiar Contraseña", color = Color.White)
        }

        // Enlace para regresar a la pantalla de login
        Text(
            "Volver al inicio de sesión",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.clickable {
                navController.popBackStack() // Regresa a la pantalla de login
            }
        )
    }
}