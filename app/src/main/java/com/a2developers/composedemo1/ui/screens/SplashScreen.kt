package com.a2developers.composedemo1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a2developers.composedemo1.R
import com.a2developers.composedemo1.ui.theme.LightGrey2
import com.a2developers.composedemo1.ui.theme.PrimaryGrey
import com.a2developers.composedemo1.ui.theme.PrimaryRed
import com.a2developers.composedemo1.ui.theme.poppins

@Composable
fun SplashScreenUI(){
    Column {
        logo()
        Hero()
    }
    MainImage()

    Box(Modifier.size(60.dp), Alignment.Center ) {
        NextButton()
    }
}


@Composable
private fun MainImage() {
    Image(
        painter = painterResource(id = R.drawable.undraw_investing),
        contentDescription = "",
        alignment = Alignment.BottomCenter,
        modifier = Modifier.padding(vertical = 60.dp, horizontal = 20.dp)
    )
}

@Composable
private fun logo() {
    Row(Modifier.padding(20.dp, 20.dp), Arrangement.Center) {
        Icon(
            painter = painterResource(id = R.drawable.ic__square),
            contentDescription = "App name",
            tint = Color.Unspecified,
        )
        Text(
            text = "Beenkio",
            Modifier
                .padding(start = 12.dp)
                .alpha(0.8f),
            fontSize = 16.sp,
            fontFamily = poppins,
            color = Color.DarkGray
        )
    }
}

@Composable
private fun Hero() {
    val annotatedString1 = AnnotatedString.Builder("Finance Your Balance Sheet")
        .apply {
            addStyle(
                SpanStyle(
                    color = PrimaryRed,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    textDecoration = TextDecoration.Underline,
                ), 12, 21
            )
        }

    val annotatedString2 =
        AnnotatedString.Builder("Best payment method, connects your money to your friends and brands")
            .apply {
                addStyle(
                    SpanStyle(
                        color = PrimaryGrey,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                    ), 49, 67
                )
            }

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            annotatedString1.toAnnotatedString(),
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            color = PrimaryGrey
        )
        Text(
            annotatedString2.toAnnotatedString(),
            color = LightGrey2,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun NextButton() {
    FloatingActionButton(onClick = { }, Modifier.size(60.dp), backgroundColor = PrimaryGrey) {
        Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = "")
    }
}