package dev.alejandrorosas.core

interface Authenticator {
    val isLoggedIn: Boolean

    fun login()
    fun logout()
}

