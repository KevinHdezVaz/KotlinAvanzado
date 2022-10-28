package com.example.kotlinavanzado.dogDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kotlinavanzado.R
import com.example.kotlinavanzado.databinding.ActivityDogDetailBinding
import com.example.kotlinavanzado.databinding.ActivityMainBinding
import com.example.kotlinavanzado.model.Dog

class DogDetailActivity : AppCompatActivity() {
    companion object{
        const val DOG_KEY ="dog"
    }
    private lateinit var binding: ActivityDogDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val dog = intent?.extras?.getParcelable<Dog>(DOG_KEY)

        if(dog == null)
        {
            Toast.makeText(this,"Dog not found",Toast.LENGTH_SHORT).show()
            finish()
            return

        }
        binding.dogIndex.text = getString(R.string.indexFormat, dog.index)
        binding.lifeExpectancy.text = getString(R.string.dogLife, dog.lifeExpectancy)

        binding.dog = dog
    }
}