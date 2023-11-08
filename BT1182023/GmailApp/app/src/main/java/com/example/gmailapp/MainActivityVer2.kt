package com.example.gmailapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gmailapp.databinding.ActivityMainBinding
import com.example.gmailapp.databinding.MainActivityVer2Binding

class MainActivityVer2 : AppCompatActivity() {
    val ADD_ITEM_REQUEST_CODE = 1
    private lateinit var binding: MainActivityVer2Binding
    var array : ArrayList<Item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityVer2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        array = ArrayList()

        binding.rcvGmail.layoutManager = LinearLayoutManager(this)
        var adapter : CustomAdapterVer2 = CustomAdapterVer2(array, this)
        binding.rcvGmail.adapter = adapter

        binding.addMesVer2.setOnClickListener { onClickAdd() }
    }

    private fun onClickAdd() {
        val intent = Intent(this, AddActivity::class.java)
        startActivityForResult(intent, ADD_ITEM_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_ITEM_REQUEST_CODE && resultCode == RESULT_OK) {
            val receivedItem = data?.getSerializableExtra("item") as? Item
            if (receivedItem != null) {
                array.add(receivedItem)
            }
        }
    }


}