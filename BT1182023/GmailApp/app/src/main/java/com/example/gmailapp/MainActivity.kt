package com.example.gmailapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gmailapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val ADD_ITEM_REQUEST_CODE = 1
    private lateinit var binding: ActivityMainBinding
    var array : ArrayList<Item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        array = ArrayList()

        array.add(Item("asfdafd", "dfsfdsdfdf", "12.90 PM", false))

        binding.listItem.adapter = CustomAdapter(this, array)
        binding.addMes.setOnClickListener { onClickAdd() }
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
                (binding.listItem.adapter as CustomAdapter).notifyDataSetChanged()
            }
        }
    }


}