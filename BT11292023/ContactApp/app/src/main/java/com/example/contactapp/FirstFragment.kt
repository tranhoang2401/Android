package com.example.contactapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var listItem : ArrayList<Contact>
    private val createFragmentRequestCode = 1

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listItem = ArrayList()
        for (n in 1..10){
            var item : Contact = Contact(n, "Tran Anh Hoang $n", "098345228", "anhhoang24012002@gmail.com")
            listItem.add(item)
        }

        val name = arguments?.getString("name")
        val phone = arguments?.getString("phone")
        val email = arguments?.getString("email")
        val contact: Contact = Contact(1, name.toString(), phone.toString(), email.toString())
        listItem.add(contact)

        Log.d("checkdb", "onViewCreated:" + name)
        binding.rcv.layoutManager = LinearLayoutManager(requireActivity()) // xét hiển thị rcv theo chiều dọc
        var adapter: ItemAdapter = ItemAdapter(listItem, requireActivity(), object : ItemAdapter.ClickContactListener {
            override fun clickLn(id: Int) {
                var contact = listItem.get(id);
                val bundle = Bundle()

                bundle.putString("id", contact.id.toString())
                bundle.putString("name", contact.name)
                bundle.putString("phone", contact.phone)
                bundle.putString("email", contact.email)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

            }

            override fun onItemLongClick(contact: Contact, view: View) {

            }
        })


        binding.rcv.adapter = adapter // xet adapter cho recycleView

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == createFragmentRequestCode && resultCode == Activity.RESULT_OK) {
            val name = data?.getStringExtra("name")
            val email = data?.getStringExtra("email")
            val phone = data?.getStringExtra("phone")

            if (name != null && email != null && phone != null) {
                val contact: Contact = Contact(1, name, phone, email)
                Log.d("checkdb", "onActivityResult: $name")
                listItem.add(contact)
            } else {
                Log.e("checkdb", "onActivityResult: Some data is null")
            }
        }else{
            Log.e("checkdb", "onActivityResult: faild")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}