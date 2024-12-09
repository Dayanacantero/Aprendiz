package com.example.aprendiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aprendiz.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoggedIn by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espacio consistente entre elementos
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Espacio extra al principio
        Spacer(modifier = Modifier.height(100.dp)) // Ajusta este valor según lo necesites

        // Logo SENA y texto de "Etapa Productiva"
        Image(
            painter = painterResource(id = R.drawable.sena), // Asegúrate de tener el logo en res/drawable
            contentDescription = "Logo SENA",
            modifier = Modifier
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Etapa Productiva", fontSize = 20.sp, color = (Color(0xFF009E00)), fontWeight = FontWeight.Bold)

        // Campo de usuario
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
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

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
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

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para iniciar sesión
        Button(
            onClick = {
                // Primer conjunto de credenciales
                if (username == "dayana@gmail.com" && password == "12345678") {
                    isLoggedIn = true
                    navController.navigate("home") // Redirige a la pantalla principal para este usuario

                    // Segundo conjunto de credenciales
                } else if (username == "Laura@gmail.com" && password == "87654321") {
                    isLoggedIn = true
                    navController.navigate("data_entry_screen") // Redirige a otra pantalla para este usuario

                    // Si las credenciales son incorrectas
                } else {
                    // Puedes mostrar un mensaje de error aquí si lo deseas
                    // Por ejemplo: "Credenciales incorrectas"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = (Color(0xFF009E00)))
        ) {
            Text("Iniciar sesión", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Enlace para la recuperación de contraseña
        Text(
            "¿Olvidaste tu contraseña?",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.clickable {
                // Navegar a la pantalla de recuperación de contraseña
                navController.navigate("forgot_password") // Asegúrate de tener esta ruta en tu NavHost
            }
        )
    }
}
