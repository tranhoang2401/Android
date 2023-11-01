package com.example.gmailapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gmailapp.databinding.ActivityAddBinding
import com.example.gmailapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvSave.setOnClickListener {
            if(checked()){
                setClickSave()
            }
        }
        binding.tvDestroy.setOnClickListener { setClickDestroy() }
    }

    private fun setClickDestroy() {
        finish()
    }

    private fun setClickSave() {
        val time = Date()
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val formattedTime = sdf.format(time)
        val item : Item = Item(binding.edtName.text.toString(), binding.edtInfomation.text.toString(), formattedTime, false)
        val intent = Intent(this, MainActivity :: class.java)
        intent.putExtra("item", item)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun checked() : Boolean {
        if(binding.edtName.text.isEmpty()){
            binding.edtName.setError("Nhập tên")
            return false
        }
        if(binding.edtInfomation.text.isEmpty()){
            binding.edtInfomation.setError("Nhập tên")
            return false
        }
        return true
    }
}