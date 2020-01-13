package dev.alejandrorosas.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.login_login_button).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginScreen_to_homeScreen)
        }
    }
}
