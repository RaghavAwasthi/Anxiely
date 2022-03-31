package com.app.anxily

import android.content.Intent
import android.os.Bundle
import com.app.anxily.databinding.ActivityLoginBinding
import com.app.base.ui.activity.BindingBaseActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BindingBaseActivity<ActivityLoginBinding>() {

    val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityLoginBinding) {
        if (FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }

    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    fun loginUser() {

        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build()
        )


        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setTheme(R.style.Theme_Anxily)
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val user = FirebaseAuth.getInstance().currentUser
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
            // ...
        } else {

        }
    }

}