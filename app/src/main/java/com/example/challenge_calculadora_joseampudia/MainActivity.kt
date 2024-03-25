package com.example.challenge_calculadora_joseampudia

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge_calculadora_joseampudia.ui.theme.Challenge_Calculadora_JoseAmpudiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            principal()
        }
    }
}

// Autor: Jose Carlos Ampudia Flores

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class) // se usa para Material (usar TopAppBar)
@Preview(showBackground = true)
@Composable
fun principal() {

    var txtNum1 by remember {
        mutableStateOf("")
    }

    var txtNum2 by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf("")
    }



    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

        // tipo menu hamburguesa
        TopAppBar(title = {
            Text(text = "Calculadora",
                color = Color.Red

            )
        }, navigationIcon = {
            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Menu")
        })

        // logo de upc
        Image(painter = painterResource(id = R.drawable.logo)
            , contentDescription = null,
            modifier = Modifier.height(200.dp)
        )

        // TEXTO CALCULADORA
        Text(text = "Calculadora",
            fontSize = 30.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )

        // caja de texto para el primer numero
        OutlinedTextField(
            value = txtNum1,
            label = {
                Text(text = "Numero 1")
            },

            onValueChange = {
                txtNum1=it
            }
        )

        // caja de texto para el segundo numero
        OutlinedTextField(
            value = txtNum2,
            label = {
                Text(text = "Numero 2")
            },

            onValueChange = {
                txtNum2=it
            }
        )


        // Row para los botones se vean en horizontal
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(10.dp)

        ) {

            // Botones de SUMA
            Button(onClick = {
                val num1 = txtNum1.toInt()  // convertimos el texto a entero
                val num2 = txtNum2.toInt()  // convertimos el texto a entero
                val res = num1 + num2       // sumamos los numeros
                resultado = res.toString()  // convertimos el resultado a texto
            }) {
                Text(text = "Sumar")

            }

            // Botones de RESTA
            Button(onClick = {
                val num1 = txtNum1.toInt()  // convertimos el texto a entero
                val num2 = txtNum2.toInt()  // convertimos el texto a entero
                val res = num1 - num2       // restamos los numeros
                resultado = res.toString()  // convertimos el resultado a texto
            }) {
                Text(text = "Restar")

            }

            // Botones de MULTIPLICACION
            Button(onClick = {
                val num1 = txtNum1.toInt()  // convertimos el texto a entero
                val num2 = txtNum2.toInt()  // convertimos el texto a entero
                val res = num1 * num2       // multiplicamos los numeros
                resultado = res.toString()  // convertimos el resultado a texto
            }) {
                Text(text = "Multiplicar")

            }

            // Botones de DIVISION
            Button(onClick = {
                val num1 = txtNum1.toInt()  // convertimos el texto a entero
                val num2 = txtNum2.toInt()  // convertimos el texto a entero
                val res = num1 / num2       // dividimos los numeros
                resultado = res.toString()  // convertimos el resultado a texto
            }) {
                Text(text = "Dividir")

            }


        }

        // boton para limpiar los numeros (se muestra en columna)
        Button(
            onClick = {
            txtNum1 = ""  // limpiamos la caja de texto
            txtNum2 = ""  // limpiamos la caja de texto
            resultado = "" // limpiamos la caja de texto
        },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Limpiar Numeros")

        }


        // mostramos el resultado de la operacion
        Text(
            text = "Resultado: $resultado", // mostramos el resultado
            fontSize = 30.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )

    }
}