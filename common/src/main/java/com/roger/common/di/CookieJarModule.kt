package com.roger.common.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.roger.common.base.http.cookie.UserCookieJarImpl
import com.roger.common.base.http.cookie.CookieCacheHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CookieJarModule {

    @Singleton
    @Provides
    fun provideCookieJar(
        @CookieDataStore dataStore: DataStore<Preferences>,
        @ApplicationScope scope: CoroutineScope,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ) = UserCookieJarImpl(CookieCacheHelper(dataStore, scope, dispatcher))
}