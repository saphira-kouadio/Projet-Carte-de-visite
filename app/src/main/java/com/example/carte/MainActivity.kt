package com.example.carte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carte.ui.theme.CarteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(
                        nom = stringResource(R.string.nom_text),
                        text1 = stringResource(R.string.ABD_text),
                        telephone = stringResource(R.string.num_text),
                        email = stringResource(R.string.email_text),
                        add = stringResource(R.string.add_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(
    nom: String,
    text1: String,
    telephone: String,
    email: String,
    add: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFA0522D), Color(0xFFFFA500)) // marron → orange
                )
            )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            val image = painterResource(R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = "Visiting Card",
                modifier = Modifier.size(180.dp)
            )
            Text(
                text = nom,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA52A2A),
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = text1,
                fontSize = 20.sp,
                modifier = modifier
            )
        }


        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 40.dp, start = 20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = "tel",
                    tint = Color.Green
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = telephone, modifier = Modifier)
            }
            Row {
                Icon(
                    Icons.Filled.MailOutline,
                    contentDescription = "em",
                    tint = Color.Blue
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = email, modifier = Modifier)
            }
            Row {
                Icon(
                    Icons.Filled.Share,
                    contentDescription = "ad",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = add, modifier = Modifier)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarteVisitePreview() {
    CarteTheme {
        GreetingText(
            nom = stringResource(R.string.nom_text),
            text1 = stringResource(R.string.ABD_text),
            telephone = stringResource(R.string.num_text),
            email = stringResource(R.string.email_text),
            add = stringResource(R.string.add_text)
        )
    }
}
