package com.example.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactapp.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val id = arguments?.getString("id")
        val name = arguments?.getString("name")
        val phone = arguments?.getString("phone")
        val email = arguments?.getString("email")
        binding.tvId.text = id
        binding.tvName.text = name
        binding.tvEmail.text = email
        binding.tvPhone.text = phone

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}