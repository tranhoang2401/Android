package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var listItem : ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // tạo đối tượng cho viewbinding của layout
        setContentView(binding.root) // xét layout cho activity



        listItem = ArrayList()
        for (n in 100..120){
            var item : Contact = Contact(n, "Tran Anh Hoàng $n", "0927387368", "hoangdzsjd@gmail.com")
            listItem.add(item)
        }
        binding.rcv.layoutManager = LinearLayoutManager(this) // xét hiển thị rcv theo chiều dọc
        var adapter: ItemAdapter = ItemAdapter(listItem, this, object : ItemAdapter.ClickContactListener{
            override fun clickLn(id: Int) {
                var contact = listItem.get(id);
                var i : Intent = Intent(this@MainActivity, DetailActivity::class.java) // chuyển sang actvity Detail
                i.putExtra("id", contact.id)
                i.putExtra("name", contact.name)
                i.putExtra("phone", contact.phone)
                i.putExtra("email", contact.email)
                startActivity(i)
            }

            override fun onItemLongClick(contact: Contact, view: View) { // xét sự kiện giữ
                val popupMenu = PopupMenu(this@MainActivity, view)
                popupMenu.inflate(R.menu.menu) // Chỉ định menu resource
                popupMenu.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.menu_action_1 -> {
                            true
                        }
                        R.id.menu_action_2 -> {
                            true
                        }
                        R.id.menu_action_3 -> {
                            true
                        }
                        else -> false
                    }
                }
                popupMenu.show()
            }

        }) //
        binding.rcv.adapter = adapter // xet adapter cho recycleView
    }
}