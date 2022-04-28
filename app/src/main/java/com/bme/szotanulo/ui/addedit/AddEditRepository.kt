package com.bme.szotanulo.ui.addedit

import androidx.annotation.WorkerThread
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.persistence.CardDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddEditRepository @Inject constructor(
    private val cardDao: CardDao
) {
    @WorkerThread
    fun getCardById(id: Long) = flow {
        val card = cardDao.get(id)
        emit(card)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun createCard(card: Card) = flow {
        val createdCard = cardDao.insert(card)
        emit(createdCard)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun editCard(card: Card) = flow {
        val deletedCard = cardDao.update(card)
        emit(deletedCard)
    }.flowOn(Dispatchers.IO)
}