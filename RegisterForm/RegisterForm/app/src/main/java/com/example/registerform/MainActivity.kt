package com.example.registerform

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registerform.databinding.ActivityMain2Binding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btSelect.setOnClickListener { showDatePickerDialog() }
        binding.btRegister.setOnClickListener {
            if(checked()) {
                Toast.makeText(this,   "Đăng ký thành công", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun checked() : Boolean{
        if(binding.edtFirstname.text.isEmpty()){
            Toast.makeText(this,   "Nhập First name", Toast.LENGTH_SHORT).show()
            return false
        }
        if(binding.edtLastname.text.isEmpty()){
            Toast.makeText(this,   "Nhập Last name", Toast.LENGTH_SHORT).show()
            return false
        }
        if(binding.radiogroup.checkedRadioButtonId == -1){
            Toast.makeText(this,   "Chọn giới tính", Toast.LENGTH_SHORT).show()
            return false
        }
        if(binding.tvBirthday.text.isEmpty()){
            Toast.makeText(this,   "Chọn ngày sinh nhật", Toast.LENGTH_SHORT).show()
            return false
        }
        if(binding.address.text.isEmpty()){
            Toast.makeText(this,   "Nhập Address", Toast.LENGTH_SHORT).show()
            return false
        }
        if(binding.edtEmail.text.isEmpty()){
            Toast.makeText(this,   "Nhập Email", Toast.LENGTH_SHORT).show()
            return false
        }

        if(!binding.checkboxagree.isChecked){
            Toast.makeText(this,   "Chọn đồng ý", Toast.LENGTH_SHORT).show()
            return false
        }



        return true
    }
    private fun showDatePickerDialog() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            binding.tvBirthday.text = selectedDate;
        }, year, month, day)

        datePickerDialog.show()
    }
}