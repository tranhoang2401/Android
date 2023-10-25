package com.example.caculatorapp

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.caculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operator: String = ""
    private var value1: Double = 0.0
    private var value2: Double = 0.0
    private var result: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tv0.setOnClickListener { btn_click(binding.tv0) }
        binding.tv1.setOnClickListener { btn_click(binding.tv1) }
        binding.tv2.setOnClickListener { btn_click(binding.tv2) }
        binding.tv3.setOnClickListener { btn_click(binding.tv3) }
        binding.tv4.setOnClickListener { btn_click(binding.tv4) }
        binding.tv5.setOnClickListener { btn_click(binding.tv5) }
        binding.tv6.setOnClickListener { btn_click(binding.tv6) }
        binding.tv7.setOnClickListener { btn_click(binding.tv7) }
        binding.tv8.setOnClickListener { btn_click(binding.tv8) }
        binding.tv9.setOnClickListener { btn_click(binding.tv9) }

        binding.tvCe.setOnClickListener { btn_click(binding.tvCe) }
        binding.tvBS.setOnClickListener { btn_click(binding.tvBS) }

        binding.tvSum.setOnClickListener { btn_operation(binding.tvSum) }
        binding.tvSubtraction.setOnClickListener { btn_operation(binding.tvSubtraction) }
        binding.tvDiv.setOnClickListener { btn_operation(binding.tvDiv) }
        binding.tvMul.setOnClickListener { btn_operation(binding.tvMul) }

        binding.tvEqual.setOnClickListener { tv_result() }
    }

    var numberclk = false
    fun btn_click(visible: View) {

        numberclk = true
        var value = binding.tvresuft.text.toString()


        when (visible.id) {

            binding.tv0.id -> {
                value += "0"
            }
            binding.tv1.id -> {
                value += "1"
            }
            binding.tv2.id -> {
                value += "2"
            }
            binding.tv3.id -> {
                value += "3"
            }
            binding.tv4.id -> {
                value += "4"
            }
            binding.tv5.id -> {
                value += "5"
            }
            binding.tv6.id -> {
                value += "6"
            }
            binding.tv7.id -> {
                value += "7"
            }
            binding.tv8.id -> {
                value += "8"
            }
            binding.tv9.id -> {
                value += "9"
            }
            binding.tvCe.id -> {
                value = ""
            }
            binding.tvBS.id -> {
                value = binding.tvresuft.text.toString()
                if (value.length > 0) {
                    value = value.substring(0, value.length - 1)
                }
            }

        }
        binding.tvresuft.setText(value)
    }

    fun btn_operation(visible: View) {

        when (visible.id) {
            binding.tvSum.id -> {
                operator = "+"
            }
            binding.tvSubtraction.id -> {
                operator = "-"
            }
            binding.tvDiv.id -> {
                operator = "/"
            }
            binding.tvMul.id -> {
                operator = "*"
            }
        }

        val value = binding.tvresuft.text.toString()
        if (numberclk) {
            value1 = value.toDouble()
        }
        numberclk = false
        binding.tvresuft.setText("")
    }
    fun tv_result() {

        val value = binding.tvresuft.text.toString()
        value2 = value.toDouble()

        when (operator) {

            "+" -> {
                result = value1 + value2
            }
            "-" -> {
                result = value1 - value2
            }
            "/" -> {
                result = value1 / value2
            }
            "*" -> {
                result = value1 * value2
            }
        }
        binding.tvresuft.setText(result.toString())
    }

}