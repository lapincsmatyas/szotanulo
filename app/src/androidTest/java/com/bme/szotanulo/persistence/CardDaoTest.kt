package com.bme.szotanulo.persistence

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.bme.szotanulo.model.Card
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class CardDaoTest {
    private lateinit var database: CardDatabase
    private lateinit var dao: CardDao

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CardDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.cardDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertCards() = runTest {
        val card = Card(
            id = 1,
            frontSide = "testF",
            backSide = "testB",
            creationDate = Date(),
            lastReviewedDate = Date()
        )
        dao.insertCards(listOf(card))

        val allCards = dao.getCards().getOrAwaitValue()
        assertThat(allCards).contains(card)
    }

    @Test
    fun deleteAllCards () = runTest {
        val card = Card(
            id = 1,
            frontSide = "testF",
            backSide = "testB",
            creationDate = Date(),
            lastReviewedDate = Date()
        )
        dao.insertCards(listOf(card, card))
        dao.deleteAllCards()

        val allCards = dao.getCards().getOrAwaitValue()
        assertThat(allCards).isEmpty()
    }
}