package com.openinapp.data.repository

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.openinapp.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException

class PreferenceRepository(private val context: Context) {
    suspend fun <T> setValue(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit {
            it[key] = value
        }
    }

    fun <T> getValue(key: Preferences.Key<T>) : Flow<T?> {
        return context.dataStore.data
            .map { it[key] }
            .catch {
                if (it is IOException) emit(null)
                else throw it
            }
    }
}