package com.bme.szotanulo.ui.main

import com.bme.szotanulo.network.CardApiService
import com.bme.szotanulo.persistence.CardDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val cardDao: CardDao,
    private val cardService: CardApiService
) {
    /*
    suspend fun getCards() {
        withContext(Dispatchers.IO) {
            val cards = cardDao.getAllCards()
            if(cards.isEmpty()){
                val data = cardService.getProperties()
                cardDao.insertCards(data)
            }
        }
    }

     */

    /*
    @WorkerThread
    fun getCards() = flow {
        val cards = cardDao.getAllCards()
        if(cards.isEmpty()){
            val data = cardService.getCards()
            cardDao.insertCards(data)
            emit(data.size)
        }
        emit(cards.size)
    }.flowOn(Dispatchers.IO)

     */
}