package com.example.metav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.metav.ui.theme.MetaVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MetaVTheme {
                Column() { //Declaring variables
                    var text by remember { mutableStateOf("") }
                    var results by remember { mutableStateOf("") }
                    Column(){ //App home icons for user interface
                        Text("MetaV")
                        OutlinedTextField(
                            value = text,
                            onValueChange = { text = it },
                            label = {
                                Text("Enter time of the day") }
                        )
                        Row(){ //asking user to enter their time of day to recieve suggestions
                            Button(
                                onClick = {
                                    results = when (text) {
                                        "Morning" -> "Send good morning text"
                                        "Midday" -> "Go to the mall"
                                        "Afternoon" -> "Take a freind out for lunch"
                                        "Evening" -> "Call a family member to check on them"
                                        "Night" -> "Send a goodnight text"
                                        else -> "Invalid input"
                                    }
                                }
                            )

                            {
                                Text("Suggest")
                            }
                            Button(
                                onClick = {
                                    text = ""
                                    results = ""
                                }
                            ){
                                Text("Reset")
                            }

                        }
                        Text(results)
                    }
            }
        }
    }
}
}





