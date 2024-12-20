package com.example.praktikum6.ui.theme.view.screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6.R


@Composable
fun SplashScreen(
    onMulaiButton:() -> Unit,
){
    Column ( modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.umy),
            contentDescription = " ",
            modifier = Modifier
                .size(150.dp)
        )

        Button(
            onClick = {
                onMulaiButton()

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            Text( "Mulai")
        }
    }
}