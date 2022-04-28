package com.bme.szotanulo.di

import android.content.Context
import androidx.room.Room
import com.bme.szotanulo.persistence.CardDao
import com.bme.szotanulo.persistence.CardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideCardDao(cardDatabase: CardDatabase): CardDao {
        return cardDatabase.cardDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CardDatabase {
        return Room.databaseBuilder(
            appContext,
            CardDatabase::class.java,
            "card_database"
        ).fallbackToDestructiveMigration()
            .build()
    }
}