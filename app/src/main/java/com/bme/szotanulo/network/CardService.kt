package com.bme.szotanulo.network

import com.bme.szotanulo.model.Card
import retrofit2.http.GET

interface CardApiService {
    @GET("cards")
    suspend fun getCards():
            List<Card>
}