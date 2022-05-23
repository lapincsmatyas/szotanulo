package com.bme.szotanulo.model

import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName="card_table")
data class Card(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "front_side")
    var frontSide: String?,

    @ColumnInfo(name = "back_side")
    var backSide: String?,

    @ColumnInfo(name = "creation_date")
    val creationDate: Date?,

    @ColumnInfo(name = "last_reviewed_date")
    val lastReviewedDate: Date?
)