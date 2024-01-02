package com.onepiecetreasurehunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onepiecetreasurehunt.ui.theme.OnePieceTreasureHuntTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnePieceTreasureHuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Treasure()
                }
            }
        }
    }
}

@Composable
fun Treasure() {
    val TreasureFound = remember {
        mutableStateOf(0)
    }
    val Direction = remember {
        mutableStateOf("North")
    }
    var isTreasureOrStorm by remember { mutableStateOf("") }

    val life = remember {
        mutableStateOf(15)
    }

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Treasures Found: ${TreasureFound.value}")
        Row {
            Text(text = "Lives Left: ${life.value}")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Current Direction: ${Direction.value}")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = isTreasureOrStorm)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Guess the direction of Treasure??")
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Button(onClick = {
                if (life.value > 0) {
                    Direction.value = "East"
                    if (Random.nextBoolean()) {
                        TreasureFound.value += 1
                        isTreasureOrStorm = "Treasure Found!!"
                    } else {
                        isTreasureOrStorm = "Storm Ahead!!"
                        life.value -= 1
                    }
                }else{
                    isTreasureOrStorm = "Game Over!!!"
                }
            }) {
                Text("Sail East")
            }


            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                if (life.value > 0) {
                    Direction.value = "West"
                    if (Random.nextBoolean()) {
                        TreasureFound.value += 1
                        isTreasureOrStorm = "Treasure Found!!"
                    } else {
                        isTreasureOrStorm = "Storm Ahead!!"
                        life.value -= 1
                    }
                }else{
                    isTreasureOrStorm = "Game Over!!!"
                }
            }) {
                Text("Sail West")
            }

            Spacer(modifier = Modifier.height(30.dp))

        }
        Row {
            Button(onClick = {
                if (life.value > 0) {
                    Direction.value = "North"
                    if (Random.nextBoolean()) {
                        TreasureFound.value += 1
                        isTreasureOrStorm = "Treasure Found!!"
                    } else {
                        isTreasureOrStorm = "Storm Ahead!!"
                        life.value -= 1
                    }
                }else{
                    isTreasureOrStorm = "Game Over!!!"
                }
            }) {
                Text("Sail North")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                if (life.value > 0) {
                    Direction.value = "South"
                    if (Random.nextBoolean()) {
                        TreasureFound.value += 1
                        isTreasureOrStorm = "Treasure Found!!"
                    } else {
                        isTreasureOrStorm = "Storm Ahead!!"
                        life.value -= 1
                    }
                }else{
                    isTreasureOrStorm = "Game Over!!!"
                }
            }) {
                Text("Sail South")
            }
        }
    }
}

@Preview
@Composable
fun TreasurePreview() {
    Treasure()
}