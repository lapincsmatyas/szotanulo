package com.bme.szotanulo.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bme.szotanulo.model.Card

@Dao
interface CardDao {
    @Insert
    fun insert(card: Card)

    @Insert
    fun insertCards(cards: List<Card>)

    @Update
    fun update(card: Card)

    @Query("SELECT * from card_table WHERE id = :key")
    fun get(key: Long): Card?

    @Query("SELECT * FROM card_table")
    fun getAllCards() : List<Card>
}