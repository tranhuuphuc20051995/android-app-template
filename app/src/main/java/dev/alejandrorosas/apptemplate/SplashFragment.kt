package dev.alejandrorosas.apptemplate

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)
    }
}
