package com.example.kotlinavanzado.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinavanzado.R
import com.example.kotlinavanzado.auth.LoginActivity
import com.example.kotlinavanzado.databinding.ActivityLoginBinding
import com.example.kotlinavanzado.databinding.ActivitySettingsBinding
import com.example.kotlinavanzado.model.User

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener{
            logout()
        }
    }

    private fun logout() {
        User.logout(this)
        val intent = Intent(this@SettingsActivity,LoginActivity::class.java)

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}