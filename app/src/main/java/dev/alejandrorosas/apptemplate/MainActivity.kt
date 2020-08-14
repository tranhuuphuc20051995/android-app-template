package dev.alejandrorosas.apptemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import dev.alejandrorosas.core.Authenticator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @Inject
    lateinit var authenticator: Authenticator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val graph = navHost.navController.navInflater.inflate(R.navigation.nav_graph).apply {
            startDestination = when (authenticator.isLoggedIn) {
                true -> R.id.nav_graph_login
                false -> R.id.nav_graph_home
            }
        }

        navHost.navController.graph = graph
    }
}
