package com.example.perfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.perfil.ui.theme.PerfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerfilTheme {

            Column(modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
            ) {

                    Text(
                        text = "CONECTADOS",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier
                            .padding(top = 32.dp, start = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    FormPerfil(
                        nombre = "Manolo",
                        profesion = "Cocinero",
                        edad = 21,
                        iconoRes = R.drawable.f32_mor
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp), // Espaciado opcional arriba/abajo
                        thickness = 1.dp,                               // Grosor de la línea
                        color = Color.Blue                              // Color rojo
                    )
                    FormPerfil(
                        nombre = "Javier",
                        profesion = "Electricista",
                        edad = 41,
                        iconoRes = R.drawable.f31_cal
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp), // Espaciado opcional arriba/abajo
                        thickness = 1.dp,                               // Grosor de la línea
                        color = Color.Blue                              // Color azul
                    )
                    FormPerfil(
                        nombre ="Maria",
                        profesion = "Diseñadora",
                        edad = 31,
                        iconoRes = R.drawable.f64_rub
                    )
                }
            }
        }
    }
}

@Composable
fun FormPerfil(
    nombre: String,
    profesion: String,
    edad: Int,
    @DrawableRes iconoRes: Int
) {
    Column(
        modifier = Modifier
            //.fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding() // Respeta la barra de estado superior (reloj, batería, etc.)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp), // Margen superior y lateral
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(painter = painterResource(id = iconoRes),
                contentDescription = "Foto de $nombre",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape))
            /*AsyncImage(
                model = "https://randomuser.me/api/portraits/men/32.jpg",
                contentDescription = "Foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )*/
            Image(painter = painterResource(id = R.drawable.descarga),
                contentDescription = "Icono",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(24.dp)
                    .clip(CircleShape))
        }

        Spacer(modifier = Modifier.height(16.dp))
Row {
    Greeting(nombre, modifier = Modifier.padding(start = 16.dp))
    Text(
        text = profesion,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .padding(start = 16.dp)
    )
    Text(text = "$edad años", color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier
        .padding(start = 16.dp))

}
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello I'm $name!",
        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier


    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PerfilTheme {
        FormPerfil(nombre = "Manolo", profesion = "Cocinero", edad = 21, iconoRes = R.drawable.f32_mor)
    }
}