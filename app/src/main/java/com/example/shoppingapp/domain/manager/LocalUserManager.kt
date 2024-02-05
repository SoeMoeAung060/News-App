package com.example.shoppingapp.domain.manager

import kotlinx.coroutines.flow.Flow

//this interface we want to save the app entry when
//the user click on get started button in the last onboarding screen

interface LocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry() : Flow<Boolean>

}