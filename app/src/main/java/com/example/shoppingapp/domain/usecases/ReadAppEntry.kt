package com.example.shoppingapp.domain.usecases

import com.example.shoppingapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() : Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}