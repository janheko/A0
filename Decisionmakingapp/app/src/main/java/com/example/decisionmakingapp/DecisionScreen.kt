package com.example.decisionmakingapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun DrawButton(
    click: Click,
    onResult: (Boolean) -> Unit
    ){

    Button(
        onClick = {
            click.addClick()
            val result = click.probability() == 1
            onResult(result)

        }
    ) {
        Text(click.text)
    }

}


@Composable
fun DecisionScreen(
){

    val okayButton = remember { Click(50, "I want to go")}
    val maybeButton = remember {Click(25, "I kind of want to go")}
    val noButton = remember {Click(10, "I do not want to go")}
    var currentWords by remember {mutableStateOf(" Choose your Fate")}
    var noteClicks by remember {mutableStateOf<Boolean?>(null)}
    var totalClicks by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))

        if (totalClicks == 0){
            currentWords = "Choose your fate"
        }
        else if (noteClicks == false) {
            currentWords = "Nah, sit at home"
        }
        else {
            currentWords = "Go for it"
        }

        Text(
            textAlign = TextAlign.Center,
            text = currentWords)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            DrawButton(okayButton){ result -> noteClicks = result }
            Spacer(modifier = Modifier.width(8.dp))

            DrawButton(maybeButton){ result -> noteClicks = result }
            Spacer(modifier = Modifier.width(8.dp))
        }

        DrawButton(noButton){ result -> noteClicks = result }

        totalClicks = okayButton.clicknum + maybeButton.clicknum + noButton.clicknum

        Text(
            textAlign = TextAlign.Center,
            text = "clicks = $totalClicks")

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "CCID Ibeziako",
            textAlign = TextAlign.Center)
        Text("ID 1863920")
    }
}