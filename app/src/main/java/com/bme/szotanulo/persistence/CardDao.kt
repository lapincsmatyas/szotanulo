package com.bme.szotanulo.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bme.szotanulo.model.Card

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCards(cards: List<Card>)

    @Query("SELECT * FROM card_table")
    fun getCards() : LiveData<List<Card>>
}