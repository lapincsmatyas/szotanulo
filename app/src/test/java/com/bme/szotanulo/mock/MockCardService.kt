package com.bme.szotanulo.mock

import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardApiService

class MockCardApiService: CardApiService {
    val cards = mutableListOf<Card>()

    override suspend fun getCards(): List<Card> {
        return cards;
    }

    override suspend fun createCard(card: Card?): Card? {
        if(card != null) {
            cards.add(card);
        }
        return card;
    }

    override suspend fun getCardById(cardId: Long): Card? {
        return cards.find { card -> card.id == cardId }
    }

    override suspend fun updateCard(cardId: Long, card: Card): Card? {
        val actCard = cards.find { card -> card.id == cardId };
        if(actCard != null){
            actCard.frontSide = card.frontSide
            actCard.backSide = card.backSide
        }
        return actCard
    }

    override suspend fun deleteCard(cardId: Long): Boolean {
        return cards.removeIf { it.id == cardId }
    }

}