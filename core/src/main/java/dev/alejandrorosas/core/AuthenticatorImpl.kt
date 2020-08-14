package dev.alejandrorosas.core

object AuthenticatorImpl : Authenticator {
    override var isLoggedIn: Boolean = false

    override fun login() {
        isLoggedIn = true
    }

    override fun logout() {
        isLoggedIn = false
    }
}
