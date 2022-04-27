package com.bme.szotanulo.network

import com.bme.szotanulo.model.Card
import java.util.*
import javax.inject.Inject

class SzotanuloService @Inject constructor() {
    fun getCards(): List<Card>{
        return listOf(Card(frontSide = "apple", backSide = "alma", creationDate = Date(), lastReviewedDate = Date()))
    }
}