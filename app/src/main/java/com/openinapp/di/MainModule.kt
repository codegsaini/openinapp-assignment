package com.openinapp.di

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.openinapp.data.repository.AuthRepository
import com.openinapp.data.repository.DashboardRepository
import com.openinapp.data.repository.PreferenceRepository
import com.openinapp.data.service.DashboardService
import com.openinapp.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun providesKtorHttpClient(@ApplicationContext context: Context): HttpClient {
        return HttpClient(Android) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    @Provides
    @Singleton
    fun providesDashboardService(
        @ApplicationContext context: Context,
        client: HttpClient
    ): DashboardService {
        return DashboardService(context, client)
    }

    @Provides
    @Singleton
    fun providesAuthRepository(@ApplicationContext context: Context) : AuthRepository {
        return AuthRepository(context)
    }

    @Provides
    @Singleton
    fun providesDashboardRepository(service: DashboardService) : DashboardRepository {
        return DashboardRepository(service)
    }

}