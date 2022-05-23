package com.bme.szotanulo.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bme.szotanulo.model.Card

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCards(cards: List<Card>)

    @Query("SELECT * FROM card_table")
    fun getCards() : LiveData<List<Card>>

    @Query("DELETE FROM card_table")
    fun deleteAllCards()

    @Query("DELETE FROM card_table WHERE id = :cardId")
    fun deleteByCardId(cardId: Long)
}