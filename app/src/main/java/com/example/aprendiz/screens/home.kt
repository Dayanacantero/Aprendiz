package com.example.aprendiz.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.aprendiz.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home() {
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
                    horizontalArrangement = Arrangement.Center,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { /* Acción de Inicio */ }) {
                        Text(text = "Inicio")
                    }
                    Spacer(modifier = Modifier.width(8.dp)) // Espacio entre botones
                    Button(onClick = { /* Acción de Calendario */ }) {
                        Text(text = "Calendario")
                    }
                }
            }
        }

}
