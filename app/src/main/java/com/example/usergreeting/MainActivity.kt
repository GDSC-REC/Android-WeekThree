package com.example.usergreeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.usergreeting.ui.theme.UserGreetingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserGreetingTheme {
                UserDrivenApp()
            }
        }
    }
}

@Composable
fun UserDrivenApp() {
    var name by remember{ mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text( text = "Hello, $output!" )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text( text = "Enter your name: " ) }
        )
        Button(
            onClick = {
                if (name != "") { output = name }
            }
        ) {
            Text( text = "OK" )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun UserDrivenPreview() {
    UserDrivenApp()
}
