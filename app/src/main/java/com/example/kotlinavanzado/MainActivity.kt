package com.example.kotlinavanzado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinavanzado.activities.SettingsActivity
import com.example.kotlinavanzado.auth.LoginActivity
import com.example.kotlinavanzado.databinding.ActivityMainBinding
import com.example.kotlinavanzado.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = User.getLoggedInUser(this)
        if(user== null){
            openActivity()
            return
        }
        binding.settingsFab.setOnClickListener{
            openSettings()
        }
    }

    private fun openSettings() {

        startActivity(Intent(this@MainActivity,SettingsActivity::class.java))

    }

    private fun openActivity() {

        startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        finish()
    }
}