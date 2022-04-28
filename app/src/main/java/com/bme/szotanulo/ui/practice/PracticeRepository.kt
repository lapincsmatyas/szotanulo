package com.bme.szotanulo.ui.practice

import androidx.annotation.WorkerThread
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.persistence.CardDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PracticeRepository @Inject constructor(
    private val cardDao: CardDao
) {
}