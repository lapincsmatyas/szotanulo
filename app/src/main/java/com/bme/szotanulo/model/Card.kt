package com.bme.szotanulo.model

import java.util.*

data class Card(
    val frontSide: String,
    val backSide: String,
    val creationDate: Date,
    val lastReviewedDate: Date
)