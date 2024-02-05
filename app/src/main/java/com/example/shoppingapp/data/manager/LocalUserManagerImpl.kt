package com.example.shoppingapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.shoppingapp.domain.manager.LocalUserManager
import com.example.shoppingapp.util.Constants
import com.example.shoppingapp.util.Constants.APP_ENTRY
import com.example.shoppingapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//here We are going to implement dataStore preferences
class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {
            //here we get USER_SETTING DataStore
            it[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[PreferencesKey.APP_ENTRY] ?: false
        }
    }
}

//To create a DataStore instance we use the preferencesDataStore delegate,
// with the Context as receiver.
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)


//Reading data from Preferences DataStore
//the first thing we need to do is define the APP_ENTRY key -
// this is a booleanPreferencesKey value that we can declare
// as a member in a private PreferencesKeys object.
private object PreferencesKey {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}