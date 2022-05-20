package com.bme.szotanulo.network

import com.bme.szotanulo.model.Card
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CardApiService {
    @GET("cards")
    suspend fun getCards(): List<Card>

    @POST("cards")
    suspend fun createCard(@Body card: Card): Card
}