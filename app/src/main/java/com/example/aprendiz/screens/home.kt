package com.example.aprendiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import com.example.aprendiz.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(60.dp)
    ) {
        // Primer LinearLayout en horizontal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.sena),
                contentDescription = null,
                modifier = Modifier.size(76.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )

            Text(
                text = "Etapa\nProductiva",
                fontSize = 13.sp,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "Dayana",
                modifier = Modifier.weight(1f)
            )
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
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                // Contenedor para el ImageButton y TextView

                    Image(
                        painter = painterResource(id = R.drawable.notificaciones),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }

                // Botones centrados
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center

                ) {
                    Button(onClick = { navController.navigate("home") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF61C449),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Inicio")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { navController.navigate("calendario") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        )) {
                        Text(text = "Calendario")
                    }

                }
            }
        InstructorContainer()
        }

}


// Función para el contenedor del instructor
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
                .background(Color(0xFFF7F7F7))// Similar a bg-gray-100
                .shadow(4.dp) // Sin paréntesis
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