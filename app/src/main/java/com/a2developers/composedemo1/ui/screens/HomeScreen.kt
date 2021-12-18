package com.a2developers.composedemo1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a2developers.composedemo1.R
import com.a2developers.composedemo1.data.SendMoneyItem
import com.a2developers.composedemo1.ui.theme.*

@Composable
fun HomeScreenUI() {
    val sendMoneyData= mutableListOf(
       SendMoneyItem(R.drawable.user1,"Jimmy","$55.90"),
       SendMoneyItem(R.drawable.user2,"Kate","$156.54"),
       SendMoneyItem(R.drawable.user3,"Smith","$840.36"),
       SendMoneyItem(R.drawable.user3,"John","$840.36")
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderUI()
        CardUI()
        DataUI()
        ServicesUI()
        SendMoneyUI(sendMoneyData)
    }
}

@Composable
fun SendMoneyUI(sendMoneyData: MutableList<SendMoneyItem>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Send Money",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        LazyRow {
            items(sendMoneyData ) {item->
                SendMoneyItemUI(item)
            }
        }
    }
}

@Composable
fun SendMoneyItemUI(item: SendMoneyItem) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .padding(end = 6.dp)
            .border(width = 0.dp, color = LightGrey2, shape = Shapes.medium)
            .padding(vertical = 10.dp)

    ) {
        Column(
            modifier = Modifier.size(width = 100.dp, height = Dp.Unspecified),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = item.name,
                color = PrimaryGrey,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Text(
                text = item.Amount,
                color = PrimaryGrey,
                modifier = Modifier.alpha(0.8f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins
            )
        }
    }
}

@Composable
fun ServicesUI() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = "Services",
            color = PrimaryGrey,
            fontFamily = FontFamily(Font(R.font.poppins)),
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            ServiceUI(R.drawable.ic_money_send, "Send", Service1)
            ServiceUI(R.drawable.ic_bill, "Bill", Service2)
            ServiceUI(R.drawable.ic_recharge, "Recharge", Service3)
            ServiceUI(R.drawable.ic_more, "More", Service4)
        }

    }

}

@Composable
fun ServiceUI(id: Int, text: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier.size(60.dp),  //avoid the oval shape
            shape = CircleShape,
            //border= BorderStroke(0.dp, color),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
        ) {
            Icon(painter = painterResource(id = id), contentDescription = "content description")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = text,
            color = PrimaryGrey,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.poppins))
        )
    }
}

@Composable
fun DataUI() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 30.dp), Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "$87.50K",
                color = PrimaryGrey,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.poppins)),
                lineHeight = 20.sp
            )
            Text(
                text = "Total Income",
                color = PrimaryGrey,
                fontFamily = FontFamily(Font(R.font.poppins)),
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
        Column {
            Text(
                text = "$12.80K",
                color = PrimaryGrey,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.poppins)),
                lineHeight = 20.sp
            )
            Text(
                text = "Total Spent",
                color = PrimaryGrey,
                fontFamily = FontFamily(Font(R.font.poppins)),
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CardUI() {
    Card(
        backgroundColor = CardRed,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(160.dp),
    ) {
        Row {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 10.dp),
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    )
                )
                Text(
                    text = "$28,067.50",
                    color = Color.White,
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    ),
                    fontSize = 30.sp
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .clip(Shapes.large)
                        .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large),
                    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryGrey),
                ) {
                    Text(
                        text = "Withdraw",
                        fontSize = 12.sp,
                        modifier = Modifier.align(alignment = CenterVertically)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.4f)
                    .size(80.dp)
                    .padding(top = 20.dp, start = 20.dp)
            )
        }

    }
}

@Composable
fun HeaderUI() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 26.dp)
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Hi John", color = PrimaryGrey,
                modifier = Modifier.alpha(0.6f),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
            )
            Text(
                text = "Welcome Back", color = PrimaryGrey,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight.Bold
            )
        }
        //Spacer(modifier = Modifier.fillMaxWidth())
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .border(width = 0.dp, Color.Transparent, shape = Shapes.medium)
                .clip(Shapes.medium)
        )
    }
}
