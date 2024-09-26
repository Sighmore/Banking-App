package sanjar.uz.bankingappui.data

import androidx.compose.ui.graphics.Brush

data class Card(

   val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: String,
    val color: Brush

)
