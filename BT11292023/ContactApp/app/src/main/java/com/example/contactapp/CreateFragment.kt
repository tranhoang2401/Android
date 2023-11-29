package com.example.contactapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.contactapp.databinding.FragmentCreateBinding



class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("name", binding.edtName.text.toString())
            bundle.putString("phone", binding.edtPhone.text.toString())
            bundle.putString("email", binding.edtEmail.text.toString())
            findNavController().navigate(R.id.action_createFragment_to_FirstFragment, bundle)
        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }
}