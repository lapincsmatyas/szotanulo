package com.bme.szotanulo.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bme.szotanulo.model.Card

@Database(entities = [Card::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CardDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
}