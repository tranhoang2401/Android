package com.example.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.databinding.ActivityDetailBinding
import com.example.contactapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras

        bundle?.let {

            bundle.apply {
                val id: Int? = getInt("id")
                binding.tvId.text = id.toString()

                val name: String? = getString("name")
                binding.tvName.text = name

                val phone: String? = getString("phone")
                binding.tvPhone.text = phone

                val email: String? = getString("email")
                binding.tvEmail.text = email
            }
        }

        binding.imgBack.setOnClickListener { finish() }
    }
}