package com.example.aprendiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aprendiz.R

@Composable
fun CalendarioScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
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
                text = "Dayana Cantero",
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
                        backgroundColor = Color.Transparent
                    )) {
                    Text(text = "Inicio")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { navController.navigate("calendario") },  colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF61C449),
                    contentColor = Color.White)
                ){
                    Text(text = "Calendario")
                }
            }
        }
    }
}