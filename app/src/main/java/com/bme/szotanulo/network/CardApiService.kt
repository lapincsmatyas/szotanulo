package com.bme.szotanulo.network

import com.bme.szotanulo.model.Card
import retrofit2.http.*

interface CardApiService {
    @GET("cards")
    suspend fun getCards(): List<Card>

    @POST("cards")
    suspend fun createCard(@Body card: Card?): Card?

    @GET("cards/{cardId}")
    suspend fun getCardById(@Path("cardId") cardId: Long): Card?

    @PATCH("cards/{cardId}")
    suspend fun updateCard(@Path("cardId") cardId: Long, @Body card: Card): Card?

    @DELETE("cards/{cardId}")
    suspend fun deleteCard(@Path("cardId") cardId: Long): Boolean

}