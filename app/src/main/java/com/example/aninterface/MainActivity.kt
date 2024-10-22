package com.example.aninterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aninterface.ui.theme.InterfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SubscriptionForm(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SubscriptionForm(modifier: Modifier = Modifier) {
    var firstInput by remember { mutableStateOf("") }
    var secondInput by remember { mutableStateOf("") }
    var isSubscribed by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = firstInput,
            onValueChange = { firstInput = it },
            label = { Text("Пароль") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = secondInput,
            onValueChange = { secondInput = it },
            label = { Text("Что-то написано") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Подписаться", modifier = Modifier.padding(end = 8.dp))
            Checkbox(
                checked = isSubscribed,
                onCheckedChange = { isSubscribed = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionFormPreview() {
    InterfaceTheme {
        SubscriptionForm()
    }
}
