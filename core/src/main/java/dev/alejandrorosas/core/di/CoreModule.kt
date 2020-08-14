package dev.alejandrorosas.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.alejandrorosas.core.Authenticator
import dev.alejandrorosas.core.AuthenticatorImpl

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {
    @Provides
    fun provideAuthenticator(): Authenticator = AuthenticatorImpl
}
