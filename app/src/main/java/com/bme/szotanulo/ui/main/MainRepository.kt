package com.bme.szotanulo.ui.main

import androidx.annotation.WorkerThread
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardService
import com.bme.szotanulo.persistence.CardDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val cardDao: CardDao,
    private val cardService: CardService
) {
    @WorkerThread
    fun getCards() = flow {
        val cards = cardDao.getAllCards()
        if(cards.isEmpty()){
            val data = cardService.getCards()
            cardDao.insertCards(data)
            emit(data)
        }
        emit(cards)
    }.flowOn(Dispatchers.IO)
}