package sanjar.uz.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sanjar.uz.bankingappui.data.Card
import sanjar.uz.bankingappui.ui.theme.BlueEnd
import sanjar.uz.bankingappui.ui.theme.BlueStart
import sanjar.uz.bankingappui.ui.theme.GreenEnd
import sanjar.uz.bankingappui.ui.theme.GreenStart
import sanjar.uz.bankingappui.ui.theme.RedEnd
import sanjar.uz.bankingappui.ui.theme.RedStart

val cards=listOf(
    Card(
        cardType = "M-pesa",
        cardName = "Till",
        cardNumber = "568 954",
        balance = "Ksh 24,000",
        color = getGradient(GreenStart, GreenEnd)
    ),
    Card(
        cardType = "Airtel",
        cardName = "Airtel Money",
        cardNumber = "+254 106 877 485",
        balance = "Ksh 39,454.67",
        color = getGradient(RedStart, RedEnd)
    ),
    Card(
        cardType = "M-pesa",
        cardName = "Pochi la biashara",
        cardNumber = "+254 116 677 439",
        balance = "Ksh 24,234.65",
        color = getGradient(GreenStart, GreenEnd)
    ),
    Card(
        cardType = "Barclays",
        cardName = "Barclays",
        cardNumber = "2365 454 7455 4675",
        balance = "Ksh 234,657.75",
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "Equity",
        cardName = "Savings",
        cardNumber = "4566 6674 7774 4555",
        balance = "Ksh 167,767.65",
        color = getGradient(RedStart, RedEnd)
    ),

    Card(
        cardType = "Cooperative",
        cardName = "Cooperative",
        cardNumber = "1236 6574 7563 8754",
        balance = "Ksh 89,857.76",
        color = getGradient(GreenStart, GreenEnd)
    ),

    )


fun getGradient(
    startColor:Color,
    endColor:Color,
): Brush{
    return  Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview(showBackground = true)
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int){
    val card=cards[index]
    var lastItemPaddingEnd=0.dp
    if(index== cards.size-1){
        lastItemPaddingEnd=16.dp
    }

    var image= painterResource(id = R.drawable.ic_mpesa)
    when (card.cardType) {
        "Airtel" -> {
            image= painterResource(id = R.drawable.ic_airtel)
        }
        "Barclays" -> {
            image= painterResource(id = R.drawable.ic_barclays)
        }
        "Equity" -> {
            image= painterResource(id = R.drawable.ic_eqity)
        }
        "Cooperative" ->{
            image= painterResource(id = R.drawable.ic_cooperative)
        }
    }
    Box(
        modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
            ) {

            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            Text(text =card.cardName ,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
                )

            Text(text =card.balance ,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text =card.cardNumber ,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}



























