package com.bme.szotanulo.model

import java.util.*

data class Kartya(
    val frontSide: String,
    val backSide: String,
    val creationDate: Date,
    val lastReviewedDate: Date
)